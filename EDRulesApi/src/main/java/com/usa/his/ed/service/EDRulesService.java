package com.usa.his.ed.service;

import com.usa.his.ed.request.EligibilitydeterminationType;
import com.usa.his.ed.response.PlanInfoType;

public interface EDRulesService {
	
	public PlanInfoType checkEligibility(EligibilitydeterminationType edType);

}
