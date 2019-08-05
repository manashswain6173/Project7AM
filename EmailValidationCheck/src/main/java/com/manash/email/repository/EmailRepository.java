package com.manash.email.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.manash.email.model.EmailEntity;

public interface EmailRepository extends JpaRepository<EmailEntity, Serializable> {
	
	@Query(value = "from EmailEntity where email=:emailId")
	public EmailEntity findByEmail(String emailId);

}