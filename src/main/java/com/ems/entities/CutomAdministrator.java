package com.ems.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CutomAdministrator implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Administrator_Entity administrator_Entity;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public CutomAdministrator (Administrator_Entity  administrator_Entity) {
		this.administrator_Entity=administrator_Entity;
	} 
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority>authorities=new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(administrator_Entity.getRole()));
		return authorities;
	}


	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return encoder.encode(administrator_Entity.getPassword());
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return administrator_Entity.getAdmin_id().toString();
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
