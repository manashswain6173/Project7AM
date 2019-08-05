package com.manash.email.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manash.email.model.EmailEntity;
import com.manash.email.service.EmailService;

@Controller
public class EmailValidateController {
	
	@Autowired
	private EmailService service;
	
	@RequestMapping(value = "/input",method = RequestMethod.GET)
	public String lunchHome() {
		return "HomePage";
	}
	
	@RequestMapping(value = "/submitForm",method =RequestMethod.GET)
	public String sumitForm(HttpServletRequest req,Model model) {
		String email=null;
		EmailEntity entity=new EmailEntity();
		String msg=null;
		email=req.getParameter("email");
		entity.setEmail(email);
		msg=service.addEmail(entity);
		model.addAttribute("msg", msg);
		return "HomePage";
	}
	@RequestMapping(value="/checkMail",method=RequestMethod.GET)
	public @ResponseBody String checkMail(HttpServletRequest req) {
		String email=null;
		String res=null;
		email=req.getParameter("emailId");
		res=service.findEmail(email);
		return res;
	}

	
}
