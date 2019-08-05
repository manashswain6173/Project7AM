package com.usa.his.ed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.usa.his.ed.request.EligibilitydeterminationType;
import com.usa.his.ed.response.PlanInfoType;
import com.usa.his.ed.service.EDRulesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
public class EDRulesRestController {
	
	@Autowired
	private EDRulesService service;

	@PostMapping(value = "/ed",consumes = "application/xml",produces = "application/xml")
	@ApiOperation(value = "for cheking eligibility determination")
	public @ResponseBody PlanInfoType getEligibilityDetails(@RequestBody  EligibilitydeterminationType edType) {
		System.out.println("Mathod started");
		//invoke service class method
		System.out.println(edType.getCitigenData()+"---"+edType.getPlanDetails());
		PlanInfoType infoType=service.checkEligibility(edType);
		System.out.println(infoType);
		
		return infoType;
		
	}

}
