package com.usa.federal.gov.ssa.dto;


import lombok.Data;

/**
 * This is the dto class is used to transfer data from presentation layer to
 * Business layer.
 * 
 * @author manash
 *
 */
@Data
public class StateNameDTO {
    /**
     * 
     */
	private Integer stateId;
	/**
	 * 
	 */
    private String stateName;
    /**
     * 
     */
    private String stateCD;

}
