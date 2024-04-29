package com.ems.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;


public class CustomEmp implements UserDetails {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Emp_Entity emp_Entity;
	
	@Autowired
	private PasswordEncoder encoder;

	public CustomEmp (Emp_Entity emp_Entity) {
		this.emp_Entity=emp_Entity;
	} 
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority>authorities=new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(emp_Entity.getRole()));
//		System.err.println(authorities);
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return encoder.encode(emp_Entity.getPassword()) ;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return emp_Entity.getEmp_id().toString();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}


}
