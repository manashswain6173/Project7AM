package com.manash.test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;
import org.drools.core.rule.Package;

import com.manash.model.Product;

/**
 * Hello world!
 *
 */
public class RulesExecutor {
	public static void main(String[] args) {
		
		//create Product Class object
		Product product=new Product();
		product.setType("silver");
		RulesExecutor exe=new RulesExecutor();
		try {
			System.out.println(exe.getOffer(product));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public  int getOffer(Product product)throws Exception {
		//load rules file into the app
		InputStream is=null;
		is=getClass().getResourceAsStream("/com/manash/resources/rules.drl");
		Reader reader=new InputStreamReader(is);
		
		PackageBuilder packageBuilder=new PackageBuilder();
		packageBuilder.addPackageFromDrl(reader);
		Package droolPackage=packageBuilder.getPackage();
		
		RuleBase ruleBase=RuleBaseFactory.newRuleBase();
		ruleBase.addPackage(droolPackage);
		
		//fire the rules
		WorkingMemory workingMemory=ruleBase.newStatefulSession();
		workingMemory.insert(product);
		workingMemory.fireAllRules();
		
		return product.getDiscount();
	}
}
