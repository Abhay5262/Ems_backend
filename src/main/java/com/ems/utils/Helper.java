package com.ems.utils;

import org.springframework.stereotype.Component;

import com.ems.entities.Administrator_Entity;
import com.ems.entities.Emp_Entity;
import com.ems.proxies.Admin_dto;
import com.ems.proxies.Emp_dto;
import com.fasterxml.jackson.databind.ObjectMapper;
@Component
public class Helper {
	public static Admin_dto entitytoAdministartor_Dto(Administrator_Entity ae) {
		ObjectMapper mapper =new ObjectMapper();
		return mapper.convertValue(ae, Admin_dto.class);
	}
	
	public static Administrator_Entity dtotoAdministartor_Entity(Admin_dto ad) {
		ObjectMapper mapper =new ObjectMapper();
		return mapper.convertValue(ad, Administrator_Entity.class);
		}
	public static Emp_Entity dtotoEmp_Entity(Emp_dto ad) {
		ObjectMapper mapper =new ObjectMapper();
		return mapper.convertValue(ad, Emp_Entity.class);
		}
	public static Emp_dto entitytoEmp_dto(Emp_Entity ae) {
		ObjectMapper mapper =new ObjectMapper();
		return mapper.convertValue(ae, Emp_dto.class);
	}
}