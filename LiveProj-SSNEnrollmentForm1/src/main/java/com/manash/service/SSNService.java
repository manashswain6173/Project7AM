package com.manash.service;

import java.util.List;

import com.manash.dto.SSNPersonDetailsDTO;

public interface SSNService {
    /**
     * 
     * @param dto
     * @return
     */
	public String enrollSSN(SSNPersonDetailsDTO dto);
	public List<SSNPersonDetailsDTO> getAllSSN();
}
