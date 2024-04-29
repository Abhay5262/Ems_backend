package com.ems.proxies;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin_dto {
	private Long admin_id;
	private String name;
	private String gender;
	private String email;
	private String contact;
	private Date dob;
	private String role;
	private String password;
}
