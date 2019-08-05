package com.manash.command;

import lombok.Data;

@Data
public class StudentCommand {
	
	private Integer regNo;
	private String firstName;
	private String lastName;
	private String gender;
	private String address;
	private String email;
	private Long mobileNo;
	private String courses;
	
	public StudentCommand() {
		System.out.println("*****StudentCommand class object is created*****");
	}
	
}
