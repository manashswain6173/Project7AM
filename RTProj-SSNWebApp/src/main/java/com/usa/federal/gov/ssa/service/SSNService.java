package com.usa.federal.gov.ssa.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.usa.federal.gov.ssa.dto.SsnDetailsDTO;
import com.usa.federal.gov.ssa.dto.StateNameDTO;
/**
 * This is the Service class is used to perform business operation in the application.
 * @author manash
 *
 */
public interface SSNService {
	/**
	 * This method gives the list of usa states to controller class.
	 * @return List<StateNameDTO>
	 */
	public List<StateNameDTO> getAllState();
	 /**
     * This method is used to enroll the new ssn 
     * @param dto
     * @return String
     */
	public String enrollSSN(SsnDetailsDTO dto);
	
	/**
	 * This method is used to get all the enrolled ssn details.
	 * @return list
	 */
	public List<SsnDetailsDTO> getAllSSN();
	
	/**
	 * This method is used to get state based on the ssn no.
	 * @param ssnNo
	 * @return String
	 */
	@Query("SELECT STATE_NAME FROM SSN_MASTER WHERE SSN_NO=:ssnNo")
	public String getStateBySSN(@Param("ssnNo") Long ssnNo);

}
