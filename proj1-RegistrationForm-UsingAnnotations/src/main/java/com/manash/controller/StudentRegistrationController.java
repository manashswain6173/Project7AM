package com.manash.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manash.command.StudentCommand;
import com.manash.dto.StudentDTO;
import com.manash.service.StudentRegistrationService;

@Controller
public class StudentRegistrationController {
	
	@Autowired
	private StudentRegistrationService service;
	
	public StudentRegistrationController() {
	System.out.println("Student Controller");
	}
	//To handle initial phase request
	@RequestMapping(value="/welcome.htm")
	public String initialRequest(Map<String,Object> map,@ModelAttribute("studCmd")StudentCommand command) {
		return "form_register";
	}
	//To handle post back request 
	@RequestMapping(value="/register.htm",method=RequestMethod.POST)
	public String postBackRequest(Map<String,Object> map,@ModelAttribute("studCmd")StudentCommand command) {
		System.out.println("Post Back Request Method");
		String msg=null;
		//copy command class properties to dto 
		StudentDTO dto=new StudentDTO();
		BeanUtils.copyProperties(command, dto);
		//invoke service method
		msg=service.register(dto);
		//add model data into model object
		map.put("msg", msg);
		map.put("cmd", command);
		return "form_register";
	}

}
