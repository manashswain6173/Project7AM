package com.manash.service;

import org.springframework.stereotype.Service;

import com.manash.dto.StudentDTO;
import com.manash.entity.StudentDetailsEntity;

@Service("studService")
public interface StudentService {
	
	public StudentDTO regStudent(StudentDTO dto);

}
