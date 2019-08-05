package com.usa.his.ed.rules;

import com.usa.his.ed.request.EligibilitydeterminationType;
import com.usa.his.ed.response.PlanInfoType;

public interface EDRulesExecutor {
	
	public PlanInfoType executeRules(EligibilitydeterminationType eligibilityType);

}
