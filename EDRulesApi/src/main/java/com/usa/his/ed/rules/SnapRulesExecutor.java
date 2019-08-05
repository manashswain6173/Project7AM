package com.usa.his.ed.rules;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;
import org.drools.core.rule.Package;

import com.usa.his.ed.request.EligibilitydeterminationType;
import com.usa.his.ed.response.PlanInfoType;

public class SnapRulesExecutor implements EDRulesExecutor {

	@Override
	public PlanInfoType executeRules(EligibilitydeterminationType eligibilityType) {
		InputStream is=null;
		Reader reader=null;
		//load the sanp rule drl file
		try {
		is=getClass().getResourceAsStream("/com/rules/SnapPlanRules.drl");
		reader=new InputStreamReader(is);
		
		//create PackageBuilder class object
		PackageBuilder packageBuilder=new PackageBuilder();
		packageBuilder.addPackageFromDrl(reader);
		Package droolPackage=packageBuilder.getPackage();
		
		RuleBase ruleBase=RuleBaseFactory.newRuleBase();
		ruleBase.addPackage(droolPackage);
		
		//fire the rules
		WorkingMemory workingMemory=ruleBase.newStatefulSession();
		workingMemory.insert(eligibilityType.getPlanDetails());
		workingMemory.fireAllRules();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return eligibilityType.getPlanDetails().getSnapPlanData().getPlanInfo();
	}

}
