package com.manash.command;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

/**
 * This is the command class used  to bind the form data
 * @author manash
 *
 */

@Data
public class PersonDetailsCommand {
	
	//Initialize logger object
	
	@NotEmpty(message = "Firstname is Mandatory")
	@Length(min = 3,max = 20,message = "Size must be in the range of 3 to 20 char")
	private String firstName;
	@NotEmpty(message = "Lastname is mandatory")
	@Length(min = 3,max = 20,message = "Size must be in the range of 3 to 20 char")
	private String lastName;
	 @DateTimeFormat(pattern="MM/dd/yyyy")
	@NotNull @Past
	private Date dob;
	@NotEmpty(message = "Please select gender")
	private String gender;
	/*@NotBlank(message = "Mobile Number is Mandatory")
	@Size(max=10,message = "Mobile number must contains 10 digit")*/
	private Long phoneNo;
	@NotEmpty(message = "Please select a state")
	private String state;
	private MultipartFile photo;
	
	public PersonDetailsCommand() {
		System.out.println("***command class object is created***");
	}
	

}
