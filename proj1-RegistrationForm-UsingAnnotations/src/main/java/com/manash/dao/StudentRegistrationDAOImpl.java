package com.manash.dao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.manash.bo.StudentBO;
import com.manash.dao.StudentRegistrationDAO;

@Repository("studDAO")
public class StudentRegistrationDAOImpl implements StudentRegistrationDAO {
	
	private static final String INSERT_STUDENT="INSERT INTO STUDENT_REG VALUES(REG_NO.NEXTVAL,?,?,?,?,?,?)";
	
	@Autowired
	private JdbcTemplate jt;

	public int insertStudent(StudentBO bo) {
		System.out.println("DAO class method");
		int count=0;
		//invoke jt method to insert student 
		count=jt.update(INSERT_STUDENT, bo.getFirstName(),bo.getLastName(),bo.getGender(),bo.getAddress(),bo.getEmail(),bo.getMobileNo());
		return count;
	}
}
