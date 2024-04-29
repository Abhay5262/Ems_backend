package com.ems.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Administrator_Entity {
	@Id
	private Long admin_id;
	private String name;
	private String gender;
	private String email;
	private Date dob;
	private String contact;
	private String role;
	private String password;
}
