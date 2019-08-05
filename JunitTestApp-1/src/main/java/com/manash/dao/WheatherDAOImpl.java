package com.manash.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manash.service.WheatherServiceLocator;

@Repository("wheather")
public class WheatherDAOImpl implements WheatherDAO {
	
	/*@Autowired
	private WheatherServiceLocator serviceLocator;*/

	@Override
	public double getTodaysTemp(int zip) {
		
		double temp=0.0;
		
		//TODO:logic to get temperature
		return temp;
	}

}
