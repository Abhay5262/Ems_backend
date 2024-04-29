package com.ems.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ems.proxies.Admin_dto;
import com.ems.proxies.Emp_dto;

@Service
public interface Admin_services {
	public String register(Admin_dto dto);

	public String updateAdminDetails(Admin_dto administartor_Dto);

	public String deleteUser(Long emp_id);
	
	public String updateUserDetails(Emp_dto student);

	public List<Emp_dto> getUsers();

	public Admin_dto getAdmin(Long id);
	
	public Emp_dto getUser(Long id);
	
	public String updatewithimg(MultipartFile file, String data);
}
