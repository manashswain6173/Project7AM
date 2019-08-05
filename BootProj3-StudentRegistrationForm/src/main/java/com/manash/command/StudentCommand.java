package com.manash.command;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Data
public class StudentCommand {
	
	private Integer regNo;
	@Length(min = 3,max=20,message = "name must contains in the renge 3 to 20 character")
	@NotEmpty(message="Name must not be blank")
	private String firstName;
	@NotBlank(message="Name must not be blank")
	@Length(min = 3,max=20,message = "name must contains in the renge 3 to 20 character")
	private String lastName;
	private String gender;
	@NotBlank(message="Address must not be blank")
	@Length(min = 3,max=20,message = "address must contains in the renge 10 to 100 character")
	private String address;
	@NotBlank(message="email must not be blank")
	private String email;
	private Long mobileNo;
	private String courses;
	public StudentCommand() {
		System.out.println("*****StudentCommand class object is created*****");
	}
	
}
