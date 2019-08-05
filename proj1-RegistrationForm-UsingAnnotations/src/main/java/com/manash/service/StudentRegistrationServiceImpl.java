package com.manash.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manash.bo.StudentBO;
import com.manash.dao.StudentRegistrationDAO;
import com.manash.dto.StudentDTO;

@Service("studService")
public class StudentRegistrationServiceImpl implements StudentRegistrationService {
	//inject dao class to service class
	@Autowired()
	private StudentRegistrationDAO dao;

	public String register(StudentDTO dto) {
		int count=0;
		//convert dto to bo
		StudentBO bo=new StudentBO();
		//copy properties from dto to bo
		BeanUtils.copyProperties(dto, bo);
		//use DAO class object to insert data into db table
		count=dao.insertStudent(bo);
		return (count!=0)?"Student Registration Sucessfull":"Student Registration Failled";
	}

}
