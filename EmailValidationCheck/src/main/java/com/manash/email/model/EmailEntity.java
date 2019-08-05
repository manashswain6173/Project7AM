package com.manash.email.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "EMAIL_MASTER")
@Data
public class EmailEntity {
	
	@Id
	@Column(name = "SRLNO")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int srlNo;
	@Column(name = "EMAIL")
	private String email;

}
