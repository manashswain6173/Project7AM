package com.usa.federal.gov.ssa.model;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

/**
 * This is the model class used to bind the form page data.
 * @author manash
 *
 */
@Data
public class SsnModel {
	
	@NotEmpty(message = "FirstName is mandatory!!")
	@Pattern(regexp="[^0-9]*",message = "Please Enter only characters")
	private String firstName;
	@NotEmpty(message = "LastName is mandatory!!")
	@Size(min = 3,max = 20)
	private String lastName;
	/*@Past
	@NotNull
	@DateTimeFormat(pattern = "dd-MM-yyyy")*/
	//@NotEmpty(message="Date of birth is required")
	private Date dob;
	@NotEmpty(message="gender is mandatory")
	private String gender;
	@NotNull(message="phone number is required")
	@Min(value = 10,message = "enter a valid mobile no")
	//@Pattern(regexp="[^a-z]*",message = "Please Enter only digits")
	private Long phoneNo;
	@NotEmpty(message="please select state")
	private String state;
	private MultipartFile photo;
	

}
