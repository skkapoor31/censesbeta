package com.censes.beta.DTO;

import lombok.Data;

@Data
public class UserDTO {

	Long userId;
	String firstName;
	String lastName;
	String constituency;
	Integer age;
	String email;
	Float x_axis;
	Float y_axis;
}
