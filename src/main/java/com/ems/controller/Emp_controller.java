package com.ems.controller;

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

import com.ems.proxies.Emp_dto;
import com.ems.services.Emp_service;

@RestController
@RequestMapping("/emp")
public class Emp_controller {

	@Autowired
	private Emp_service emp_service;

	@PostMapping("/register")
	public ResponseEntity<String> registerWithDetails(@RequestParam("file")MultipartFile file, @RequestParam("data") String data) {

		return new ResponseEntity<String>(emp_service.registerWithDetails(file,data), HttpStatus.ACCEPTED);
	}

	@PostMapping("/updateUser")
	public ResponseEntity<String> updateUserDetails(@RequestBody Emp_dto student) {
		return new ResponseEntity<String>(emp_service.updateUserDetails(student), HttpStatus.ACCEPTED);
	}

	@GetMapping("/getUser/{id}")
	public ResponseEntity<Emp_dto> getUser(@PathVariable Long id) {
		System.err.println(id);
		return new ResponseEntity<Emp_dto>(emp_service.getUser(id), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/updateuserwithimg")
	public ResponseEntity<String> updateWithDetails(@RequestParam(required = false,value = "file")MultipartFile file,  @RequestParam("data") String data) {

		return new ResponseEntity<String>(emp_service.updatewithimg(file,data), HttpStatus.ACCEPTED);
	}
}
