package com.manash.email.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleMailController {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value = "/sendEmail",method = RequestMethod.GET)
	public @ResponseBody String sendMail() {
	  try {
		  sendEmail();
		  return "Email Sending successfully";	  
		  
	  }
	  catch(Exception e) {
		  return "Error in sending mail"+e;
	  }
	}
	
	private void sendEmail() throws MessagingException {
		String[] to=new String[] {"manashswain7008@gmail.com","sashmitapradhan17@gmail.com"};
		MimeMessage message =mailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message);
		//helper.setTo("manashswain7008@gmail.com");
		helper.setTo(to);
		helper.setSubject("welcome message");
		helper.setText("********Hii...WelCome to Java Mail API********");
		mailSender.send(message);
		
	}

}
