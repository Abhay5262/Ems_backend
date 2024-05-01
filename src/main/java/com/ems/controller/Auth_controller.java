package com.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.reqresp.Request;
import com.ems.reqresp.Response;
import com.ems.userdetails.ProjectUserDetails;
import com.ems.utils.Jwtutil;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class Auth_controller {
	
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private ProjectUserDetails projectUserDetails;
	
	@Autowired
	private Jwtutil jwtUtils;
	
		
	@PostMapping("/login")
	public ResponseEntity<Response> loginWithCredentials(@RequestBody Request loginRequest)
	{
		try {
			projectUserDetails.setRole(loginRequest.getRole());
//			System.err.println(loginRequest);
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		UserDetails userDetails = projectUserDetails.loadUserByUsername(loginRequest.getUsername());
		
		String token = jwtUtils.generateToken(userDetails);
		
		return new ResponseEntity<Response> (new Response(token),HttpStatus.OK);
	}
	
	
	@PostMapping("/validate")
	public ResponseEntity<String> ValidateToken()
	{
		return new ResponseEntity<String> ("JWT Token Working",HttpStatus.ACCEPTED);
	}
	
	
}	
