package com.ems.serviceimpl;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.ems.entities.Emp_Entity;
import com.ems.proxies.Emp_dto;
import com.ems.repositories.Emp_repo;
import com.ems.services.Emp_service;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Emp_serviceimpl implements Emp_service {

	@Autowired
	private Emp_repo emp_repo;

	

	@Override
	public String updateUserDetails(Emp_dto emp_dto) {
		Emp_Entity emp_Entity = emp_repo.findById(emp_dto.getEmp_id()).get();
		emp_Entity.setName(emp_dto.getName());
		emp_Entity.setCollegename(emp_dto.getCollegename());
		emp_Entity.setContact(emp_dto.getContact());
		emp_Entity.setDepartment(emp_dto.getDepartment());
		emp_Entity.setDob(emp_dto.getDob());
		emp_Entity.setEmail(emp_dto.getEmail());
		emp_Entity.setGender(emp_dto.getGender());
		emp_Entity.setQualification(emp_dto.getQualification());
		emp_Entity.setPassingyear(emp_dto.getPassingyear());
		emp_Entity.setImg(emp_dto.getImg());
		emp_Entity.setSalary(emp_dto.getSalary());
		emp_Entity.setExperince(emp_dto.getExperince());
		emp_Entity.setRole(emp_dto.getRole());
		emp_repo.save(emp_Entity);
		return "Data Has Been Updated";
	}

	@Override
	public Emp_dto getUser(Long id) {
		Emp_Entity byId = emp_repo.findById(id).get();
		Emp_dto entitytoStudent_Dto = com.ems.utils.Helper.entitytoEmp_dto(byId);
		return entitytoStudent_Dto;
	}

	@Override
	public String registerWithDetails(MultipartFile file, String data)  {
		try {
			
		
		String imagePath = "C:\\Users\\AbhayJoshi\\OneDrive - Online PSB Loans Limited\\Desktop\\Angular\\Employe_System\\src\\assets";
		
		Emp_Entity user = new Emp_Entity();
		
		ObjectMapper mapper=new ObjectMapper();
		Emp_dto dto = mapper.readValue(data, Emp_dto.class);
		user.setCollegename(dto.getCollegename());
		user.setContact(dto.getContact());
		user.setDepartment(dto.getDepartment());
		user.setDob(dto.getDob());
		user.setEmail(dto.getEmail());
		user.setEmp_id(dto.getEmp_id());
		user.setExperince(dto.getExperince());
		user.setGender(dto.getGender());
		user.setName(dto.getName());
		user.setQualification(dto.getQualification());
		user.setPassingyear(dto.getPassingyear());
		user.setSalary(dto.getSalary());
		user.setRole(dto.getRole());
		user.setPassword(dto.getPassword());
		
		String img=(UUID.randomUUID().toString().concat(file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."))));
		
		Files.copy(file.getInputStream(), Path.of(imagePath+File.separator+img), StandardCopyOption.REPLACE_EXISTING);
		
		user.setImg(img);
		
		emp_repo.save(user);
		
		return "Data Stored";
		} catch (Exception e) {
			
			return e.getMessage();
		}
	}

	@Override
	public String updatewithimg(MultipartFile file, String data) {
		try {
			
			System.err.println("PRINCE");
//			String imagePath = new ClassPathResource("/img").getFile().getAbsolutePath();
			String imagePath = "C:\\Users\\AbhayJoshi\\OneDrive - Online PSB Loans Limited\\Desktop\\Angular\\Employe_System\\src\\assets";
			
			
			
			ObjectMapper mapper=new ObjectMapper();
			Emp_dto dto = mapper.readValue(data, Emp_dto.class);
			
			Emp_Entity emp_Entity = new Emp_Entity();
			System.err.println(emp_Entity);
			
			emp_Entity.setEmp_id(dto.getEmp_id());
			emp_Entity.setCollegename(dto.getCollegename());
			emp_Entity.setContact(dto.getContact());
			emp_Entity.setDepartment(dto.getDepartment());
			emp_Entity.setDob(dto.getDob());
			emp_Entity.setEmail(dto.getEmail());
			emp_Entity.setEmp_id(dto.getEmp_id());
			emp_Entity.setExperince(dto.getExperince());
			emp_Entity.setGender(dto.getGender());
			emp_Entity.setName(dto.getName());
			emp_Entity.setQualification(dto.getQualification());
			emp_Entity.setPassingyear(dto.getPassingyear());
			emp_Entity.setSalary(dto.getSalary());
			emp_Entity.setRole(dto.getRole());
			emp_Entity.setPassword(dto.getPassword());
			
//			String img=(UUID.randomUUID().toString().concat(file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."))));
			
			if(file !=null) {
				Files.copy(file.getInputStream(), Path.of(imagePath+File.separator+dto.getImg()), StandardCopyOption.REPLACE_EXISTING);
			}
			
			
			emp_Entity.setImg(dto.getImg());
			
			System.err.println(emp_Entity);
			emp_repo.save(emp_Entity);
			
			return "Data Stored";
			} catch (Exception e) {
				
				return e.getMessage();
			
			}
	}
	
	


}
