package com.manash.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manash.email.model.EmailEntity;
import com.manash.email.repository.EmailRepository;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private EmailRepository repo;

	@Override
	public String addEmail(EmailEntity entity) {
		EmailEntity entity1=null;
		entity1=repo.save(entity);
		
		return (entity1.getSrlNo()!=0)?"Email Registred Successfully":"Email Registration Failled";
	}
	@Override
	public String findEmail(String email) {
		EmailEntity entity=null;
	    entity=	repo.findByEmail(email);
		
		return (entity.getSrlNo()!=0)?"duplicate":"unique"; 
	}

}
