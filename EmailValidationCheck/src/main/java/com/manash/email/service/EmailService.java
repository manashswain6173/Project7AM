package com.manash.email.service;

import com.manash.email.model.EmailEntity;

public interface EmailService {
	
	public String addEmail(EmailEntity entity);
	public String findEmail(String email);

}
