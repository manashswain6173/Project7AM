package com.usa.federal.gov.ssa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.Data;

/**
 * This is the StateMaster entity class is used to map with StateMaster table.
 * @author manas
 *
 */

@Entity
@Table(name="USA_STATES_MASTER")
@Data
public class StateMasterEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="STATE_ID")
	private Integer stateId;
	@Column(name="STATE_NAME")
	private String stateName;
	@Column(name="STATE_CD")
	private String stateCD;

}
