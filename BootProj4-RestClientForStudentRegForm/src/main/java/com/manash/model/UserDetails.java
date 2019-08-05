package com.manash.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;


@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UserDetails {
	
	private Integer id;
	private String fName;
	private String lName;
	private UserAddress address;
	private Long mobileNo;
	private String eMail;
	

}