package com.manash.entity;

import java.io.Serializable;
import java.sql.Date;

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
import javax.persistence.TableGenerator;

import lombok.Data;

/**
 * This is the entity class that is mapped with the database table.
 * @author manash
 *
 */
@Data
@Entity
@Table(name="SSN_PERSON")
public class SSNDetailsEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8667050522274606149L;
	
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
	@Column(name="STATE")
	private String state;
	@Column(name="PHOTO",columnDefinition ="BLOB NOT NULL")
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] photo;

}
