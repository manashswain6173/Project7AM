package com.usa.his.admin.dto;

import java.util.Date;

import lombok.Data;
/**
 * This is helper class is used  to transfer data from presentation layer to service layer.
 * @author manas
 *
 */

@Data
public class AdminDTO {
	
	private Integer adminId;
	private String firstName;
	private String lastName;
	private String gender;
	private String email;
	private String password;
	private Date dob;
	private String ssn;
	private Long mobileNo;
	private String roles;

}
