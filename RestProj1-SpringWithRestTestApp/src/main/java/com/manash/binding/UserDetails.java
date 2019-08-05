package com.manash.binding;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@ApiModel(description = "This is the model class that represents the User Details")
public class UserDetails {
	@XmlElement(name="id")
	@ApiModelProperty
	private Integer id;
	@XmlElement(name="fName")
	@ApiModelProperty
	private String fName;
	@ApiModelProperty
	@XmlElement(name="lName")
	private String lName;
	@ApiModelProperty
	@XmlElement(name="address")
	private UserAddress address;
	@ApiModelProperty
	@XmlElement(name="mobileNo")
	private Long mobileNo;
	@ApiModelProperty
	@XmlElement(name="eMail")
	private String eMail;
	

}
