package com.manash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manash.model.UserAddress;
import com.manash.model.UserDetails;
import com.manash.service.UserService;

@Controller()
public class UserController {
	
	@Autowired
	private UserService service;
	/*
	@RequestMapping(value="/user",method = RequestMethod.GET)
	public String getUser(Model model) {
		UserDetails user=service.getUser();
		model.addAttribute("userDetails",user);
		return "userDetails";
		
	}*/
	@RequestMapping(value="/user",method = RequestMethod.GET)
	public String getUser(Model model) {
		UserDetails user=service.searchUser();
		model.addAttribute("userDetails",user);
		return "userDetails";
		
	}
	@RequestMapping(value = "/home",method=RequestMethod.GET)
	public String showHome() {
		return "home";
	}
	
	@RequestMapping(value="/addUser",method=RequestMethod.GET)
	public String addUser(Model model) {
		//create UserDetails object 
		UserAddress address=new UserAddress();
		address.setHouseNo(555);address.setStreet("balkmpet");
		address.setState("Telengana");address.setCountry("India");
		address.setZipCode(500038);
		UserDetails details=new UserDetails();
		details.setId(201);details.setFName("sunil");
		details.setLName("swain");details.setAddress(address);
		details.setEMail("sunil@gamil.com");details.setMobileNo(7077144835l);
		String msg=service.addUser(details);
		model.addAttribute("succMsg", msg);
		return "userDetails";
	}

}
