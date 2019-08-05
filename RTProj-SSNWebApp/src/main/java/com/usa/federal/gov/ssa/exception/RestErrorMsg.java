package com.usa.federal.gov.ssa.exception;

import java.util.Date;

import lombok.Data;

@Data
public class RestErrorMsg {
	
	private Integer errorCode;
	private String desc;
	private Date date;

}
