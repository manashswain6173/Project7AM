package com.manash.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
/**
 * This is the entity class that is mapped with the database table.
 * @author manash
 *
 */

@Entity
@Table(name="STUDENT_REG_TAB")
@Data
public class StudentDetailsEntity implements Serializable {
	
	@Id
	@Column(name="REG_NO",length=10,unique=true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer regNo;
	@Column(name="FIRST_NAME",length=20)
	private String firstName;
	@Column(name="LAST_NAME",length=20)
	private String lastName;
	@Column(name="GENDER",length=2)
	private String gender;
	@Column(name="ADDRESS",length=100)
	private String address;
	@Column(name="EMAIL",length=20)
	private String email;
	@Column(name="MOBILE_NO",length=10)
	private Long mobileNo;
	@Column(name="COURSES",length=130)
	private String courses;

}
