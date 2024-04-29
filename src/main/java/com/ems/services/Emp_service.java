package com.ems.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ems.proxies.Emp_dto;

@Service
public interface Emp_service {

	public String registerWithDetails(MultipartFile file,String data) ;

	public String updateUserDetails(Emp_dto student);

	public Emp_dto getUser(Long id);

	public String updatewithimg(MultipartFile file, String data);

}
