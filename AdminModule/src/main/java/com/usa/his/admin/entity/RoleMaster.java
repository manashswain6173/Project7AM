package com.usa.his.admin.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Entity
@Table(name="ROLE_MASTER")
public class RoleMaster implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "SRLNO",length = 2)
	@Type(type="int")
	private Integer  srlNo;
	@Column(name="ROLE",length = 15)
	@Type(type="string")
	private String role;

}
