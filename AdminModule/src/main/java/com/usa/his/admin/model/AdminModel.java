package com.usa.his.admin.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
/**
 * This is the model class is used to bind the form data
 * @author manash
 *
 */
@Data
public class AdminModel implements Serializable {
	
	private Integer adminId;
	private String firstName;
	private String lastName;
	private String gender;
	private String email;
	private String password;
	private Date dob;
	private String ssn;
	private Long mobileNo;
	private String[] roles;
	
}
