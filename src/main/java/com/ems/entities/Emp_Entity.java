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
public class Emp_Entity {
	@Id
	private Long emp_id;
	private String name;
	private String gender;
	private String contact;
	private String salary;
	private String email;
	private Date dob;
	private String department;
	private String qualification;
	private Integer passingyear;
	private Double experince;
	private String collegename;
	private String img;
	private String password;
	private String role;
}
