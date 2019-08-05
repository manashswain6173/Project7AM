package com.manash.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manash.dto.SSNPersonDetailsDTO;
import com.manash.entity.SSNDetailsEntity;
import com.manash.repositery.SSNEnrollRepositery;
import com.manash.utility.SSNAppsUtil;

@Service("ssnService")
public class SSNServiceImpl implements SSNService {

	@Autowired
	private SSNEnrollRepositery ssnRepo;
    
	@Override
	public String enrollSSN(SSNPersonDetailsDTO dto) {
		SSNDetailsEntity entity = null;
		// convert dto to entity class object
		entity = new SSNDetailsEntity();
		// copy properties from dto to entity
		BeanUtils.copyProperties(dto, entity);
		entity.setDob(SSNAppsUtil.convertSQLDate(dto.getDob()));
		try {
			entity.setPhoto(dto.getPhoto().getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// perform insert operation
		SSNDetailsEntity insertedData = ssnRepo.save(entity);
		// return inserted data to controller
		return (insertedData != null) ? "SSN Enrollment Completed Succesfully with "+(SSNAppsUtil.formatSSNNumber(insertedData.getSsnNo()))+"."
				: "Failed to complete Enrollment";
	}

	@Override
	public List<SSNPersonDetailsDTO> getAllSSN() {
		List<SSNPersonDetailsDTO> listDTO=new ArrayList<SSNPersonDetailsDTO>();
		List<SSNDetailsEntity> listEntity=null;
		//use repo class to get all ssn details
		listEntity=ssnRepo.findAll();	
		//convert entity class object to dto object
		listEntity.forEach(entity->{
		SSNPersonDetailsDTO	dto=new SSNPersonDetailsDTO();
		BeanUtils.copyProperties(entity, dto);
	    listDTO.add(dto);
		});
		return listDTO;
	}

}
