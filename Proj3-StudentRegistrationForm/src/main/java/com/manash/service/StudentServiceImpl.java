package com.manash.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manash.dto.StudentDTO;
import com.manash.entity.StudentDetailsEntity;
import com.manash.repositery.StudentCurdRepositery;

@Service("studService")
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentCurdRepositery repo;

	@Override
	public StudentDTO regStudent(StudentDTO dto) {
		StudentDetailsEntity entity=null;
		//create Entity object
		entity=new StudentDetailsEntity();
		//copy properties from dto to entity
		BeanUtils.copyProperties(dto,entity);
		//invoke repository methods
	    entity=repo.save(entity);
	    //convert entity class object dto
	    BeanUtils.copyProperties(entity,dto);
		return dto;
	}
}
