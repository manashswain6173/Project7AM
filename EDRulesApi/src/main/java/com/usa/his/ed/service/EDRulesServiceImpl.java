package com.usa.his.ed.service;

import java.lang.reflect.Method;

import org.springframework.stereotype.Service;

import com.usa.his.ed.request.EligibilitydeterminationType;
import com.usa.his.ed.response.PlanInfoType;
import com.usa.his.ed.rules.EDRulesExecutor;
import com.usa.his.ed.rules.SnapRulesExecutor;

@Service
public class EDRulesServiceImpl implements EDRulesService {

	@Override
	public PlanInfoType checkEligibility(EligibilitydeterminationType edType) {
		PlanInfoType type=null;
		String planName=null;
		//get plan name form edtype
		//planName=edType.getCitigenData().getPlanSelected();
		planName="Snap";
		//load plan class dynamically based on the 
		try {
		Class clz=Class.forName("com.usa.his.ed.rules."+planName+"RulesExecutor");
		//create object for the loaded class
		EDRulesExecutor edRules=(EDRulesExecutor)clz.newInstance();
		//get all the methods
		Method method=clz.getDeclaredMethod("executeRules",EligibilitydeterminationType.class);
		//invoke the method
		 type=(PlanInfoType)method.invoke(edRules, edType);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return type ;
	}

}
