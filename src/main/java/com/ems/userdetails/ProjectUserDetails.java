package com.ems.userdetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.ems.entities.Administrator_Entity;
import com.ems.entities.CustomEmp;
import com.ems.entities.CutomAdministrator;
import com.ems.entities.Emp_Entity;
import com.ems.repositories.Admin_repo;
import com.ems.repositories.Emp_repo;


@Component
public class ProjectUserDetails {

	@Autowired
	private Emp_repo  studentRepo;
	
	@Autowired
	private Admin_repo administartor_repo;
//	
	public String role;
	
	public void setRole(String role){
		this.role=role;
	}
	
	public UserDetails loadUserByUsername(String id)
	{
//		Student_Entity student = studentRepo.findById(name).get();
//		 Administartor_Entity administartor_Entity=administartor_repo.findById(name).get();
				if (role.equals(Role.ROLE_ADMIN.toString())) {
//				if (true) {
		 
					Administrator_Entity administrator = administartor_repo.findById(Long.parseLong(id)).get();
					System.err.println(administrator);
					if (administrator != null) {
//						return new User(administrator.getId(), administrator.getPassword(), new ArrayList<>());
						return new CutomAdministrator(administrator);
					} else {
						throw new UsernameNotFoundException("Admin name is invalid");
					}
		 
				}
		 
				else if (role.equals(Role.ROLE_USER.toString())) {
//				else if (true) {
					
		 
					Emp_Entity student_Entity = studentRepo.findById(Long.parseLong(id)).get();
		 
					if (student_Entity != null) {
//						return new User(student.getEnrollmentNo(), student.getPassword(), new ArrayList<>());
						
						return new CustomEmp(student_Entity);
					} else {
						throw new UsernameNotFoundException("User name is invalid");
					}
		 
				}
		 
				else {
					System.out.println("Select Your Role Propurly..!!");
					return null;
				}
		 
			}
}
