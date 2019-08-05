package com.manash.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UserAddress {
	
	@XmlElement(name="housrNo")
	private Integer houseNo;
	@XmlElement(name="street")
	private String street;
	@XmlElement(name="state")
	private String state;
	@XmlElement(name="country")
	private String country;
	@XmlElement(name="zipCode")
	private Integer zipCode;
	

}
