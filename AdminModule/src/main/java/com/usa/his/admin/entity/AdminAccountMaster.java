package com.usa.his.admin.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

/**
 * This is the entity class is mapped with the database table.
 * @author manas
 *
 */
@Data
@Entity
@Table(name = "ADMIN_ACCOUNT_MASTER")
public class AdminAccountMaster implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ADMIN_ID")
	@SequenceGenerator(name = "admin_id_seq",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator = "admin_id_seq",strategy = GenerationType.SEQUENCE)
	private Integer adminId;
	@Column(name = "FIRST_NAME",length = 15)
	@Type(type = "string")
	private String firstName;
	@Column(name = "LAST_NAME",length = 15)
	@Type(type = "string")
	private String lastName;
	@Column(name="GENDER",length = 10)
	@Type(type="string")
	private String gender;
	@Column(name="EMAIL",length = 20)
	@Type(type="string")
	private String email;
	@Column(name="PASSWORD",length = 10)
	@Type(type="string")
	private String password;
	@Column(name="DOB")
	private Date dob;
	@Column(name="SSN",length = 10)
	private String ssn;
	@Column(name="MOBILE_NO")
	@Type(type="long")
	private Long mobileNo;
	@Column(name="ROLES",length = 15)
	@Type(type="string")
	private String roles;
	
	

}
