package com.usa.federal.gov.ssa.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.usa.federal.gov.ssa.exception.NoDataFoundException;
import com.usa.federal.gov.ssa.service.SSNService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(description = "This is the RestController Resource class. It handles the requet that comes from the other web project")
public class SsnRestController {
	
	@Autowired
	private SSNService service;
	
	@GetMapping(value = "/findState/{ssnNo}",produces = "application/json")
	@ApiOperation("This is the rest resource method.It handle the request and takes the ssn number and returns the State name.")
	public String getStateBySSN(@PathVariable("ssnNo")String ssn) {
		Long ssnNo=null;
		String stateName=null;
		try {
		ssnNo=Long.valueOf(ssn);
		//invoke service class method
		stateName=service.getStateBySSN(ssnNo);
		}catch(Exception e) {
			throw new NoDataFoundException(e.getMessage());
		}
		return stateName;
	}

}
