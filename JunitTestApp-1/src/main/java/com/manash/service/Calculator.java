package com.manash.service;

import org.springframework.stereotype.Service;

@Service
public class Calculator {
	
	public Calculator() {
		System.out.println("Calculator class object is created");
	}
	
	public double add(double a,double b) {
		return a+b;
	}
    
	public double mul(double a,double b) {
		return a*b;
	}

	public double div(double a,double b) {
		return a/b;
	}

}
