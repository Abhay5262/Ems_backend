package com.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ems.proxies.Admin_dto;
import com.ems.proxies.Emp_dto;
import com.ems.services.Admin_services;

@RestController
@RequestMapping("/admin")
public class Admin_controller {
	
	@Autowired
	private Admin_services admin_services;
	
	
	
	@PostMapping("/register")
	public ResponseEntity<String>register(@RequestBody Admin_dto dto){
		return new ResponseEntity<String>(admin_services.register(dto), HttpStatus.OK);
	}
	
	@PostMapping("/updateAdmin")
	public ResponseEntity<String>updateAdminDetails(@RequestBody Admin_dto administartor_Dto){
//		System.err.println("ADMIN"+administartor_Dto);
		return new ResponseEntity<String>(admin_services.updateAdminDetails(administartor_Dto),HttpStatus.OK);
	}
	@PostMapping("/updateUser")
	public ResponseEntity<String>updateUserDetails(@RequestBody Emp_dto emp_Dto){
		return new ResponseEntity<String>(admin_services.updateUserDetails(emp_Dto),HttpStatus.OK);
	}
	@PostMapping("/deleteUser/{emp_id}")
	public ResponseEntity<String>deleteUser(@PathVariable Long emp_id){
		return new ResponseEntity<String>(admin_services.deleteUser(emp_id),HttpStatus.OK);
	}
	
	@GetMapping("/getallUsers")
	public ResponseEntity<List<Emp_dto>> getUsers(){
		return new ResponseEntity<List<Emp_dto>>(admin_services.getUsers(),HttpStatus.OK);
	}
	
	@GetMapping("/getAdmin/{id}")
	public ResponseEntity<Admin_dto>getAdmin(@PathVariable Long id){
		
		return new ResponseEntity<>(admin_services.getAdmin(id),HttpStatus.ACCEPTED);
	}
	@PostMapping("/updateuserwithimg")
	public ResponseEntity<String> updateWithDetails(@RequestParam(value = "file", required = false)MultipartFile file, @RequestParam("data") String data) {
//		System.err.println(file+data);
		return new ResponseEntity<String>(admin_services.updatewithimg(file,data), HttpStatus.ACCEPTED);
	}
}
