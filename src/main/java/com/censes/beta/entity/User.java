package com.censes.beta.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name = "User_table")
public class User {

	@Id
	@Column(name = "uuid")
	@GeneratedValue( strategy= GenerationType.AUTO ) 
	private Long userid;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="constituency")
	private String constituency;
	@Column(name="age")
	private int age;
	@Column(name="email")
	private String email;
	private float x_axis;
	private float y_axis;
}
