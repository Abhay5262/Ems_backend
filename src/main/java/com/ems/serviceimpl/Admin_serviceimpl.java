package com.ems.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.ems.entities.Administrator_Entity;
import com.ems.entities.Emp_Entity;
import com.ems.proxies.Admin_dto;
import com.ems.proxies.Emp_dto;
import com.ems.repositories.Admin_repo;
import com.ems.repositories.Emp_repo;
import com.ems.services.Admin_services;
import com.ems.utils.Helper;


@Component
@Primary
@Transactional
public class Admin_serviceimpl extends Emp_serviceimpl implements Admin_services {

	@Autowired
	private Admin_repo administartor_repo;
	
	@Autowired
	private Emp_repo emp_repo;
	
	@Override
	public String register(Admin_dto dto) {   
		Administrator_Entity dtotoAdministartor_Entity = com.ems.utils.Helper.dtotoAdministartor_Entity(dto);
		administartor_repo.save(dtotoAdministartor_Entity);
		return "Data Has Been Saved";
	}

	@Override
	public String updateAdminDetails(Admin_dto administartor_Dto) {
		Administrator_Entity administartor_Entity = administartor_repo.findById(administartor_Dto.getAdmin_id()).get();
		administartor_Entity.setName(administartor_Dto.getName());
		administartor_Entity.setContact(administartor_Dto.getContact());
		administartor_Entity.setDob(administartor_Dto.getDob());
		administartor_Entity.setEmail(administartor_Dto.getEmail());
		administartor_Entity.setGender(administartor_Dto.getGender());
		administartor_Entity.setRole(administartor_Dto.getRole());
		administartor_Entity.setPassword(administartor_Dto.getPassword());
		administartor_repo.save(administartor_Entity);
		
		return "Data Has been Updated";
	}

	@Override
	public String deleteUser(Long emp_id) {
		emp_repo.deleteById(emp_id);
		return "Employee Has Been Deleted";
	}

	@Override
	public List<Emp_dto> getUsers() {
		List<Emp_Entity> e=emp_repo.findAll();
		List<Emp_dto> dto=new ArrayList<>();
		
		for (Emp_Entity se : e) {
			Emp_dto dto1=com.ems.utils.Helper.entitytoEmp_dto(se);
			dto.add(dto1);
		}
	return dto;	
	}

	@Override
	public Admin_dto getAdmin(Long id) {
		Administrator_Entity administartor_Entity = administartor_repo.findById(id).get();
		Admin_dto entitytoAdministartor_Dto = Helper.entitytoAdministartor_Dto(administartor_Entity);
		return entitytoAdministartor_Dto;
	}

}
