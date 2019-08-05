package com.usa.federal.gov.ssa.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



import lombok.Data;

/**
 * This is the entity class that is mapped with the database table.
 * @author manash
 *
 */
@Data
@Entity
@Table(name="SSN_MASTER")
public class SsnMasterEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="SSN_NO")
	@SequenceGenerator(name="SSN_NO",initialValue = 887766554,allocationSize = 1)
	@GeneratedValue(generator = "SSN_NO",strategy = GenerationType.SEQUENCE)
	private Long ssnNo;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="DOB")
	private Date dob;
	@Column(name="GENDER")
	private String gender;
	@Column(name="PHONE_NO")
	private Long phoneNo;
	@Column(name="STATE_NAME")
	private String state;
	@Column(name="PHOTO",columnDefinition ="BLOB NOT NULL")
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] photo;
	

}
