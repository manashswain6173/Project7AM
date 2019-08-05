package com.manash.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class SSNPersonDetailsDTO {
	
	private Long ssnNo;
	private String firstName;
	private String lastName;
	private Date dob;
	private String gender;
	private Long phoneNo;
	private String state;
	private MultipartFile photo;

}
