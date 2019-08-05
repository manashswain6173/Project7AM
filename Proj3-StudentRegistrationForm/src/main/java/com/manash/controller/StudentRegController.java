package com.manash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manash.command.StudentCommand;
import com.manash.service.StudentService;

@Controller
public class StudentRegController {
	
	@Autowired
	private StudentService service;
	/**
	 * This Method lunches the home page of student registration form.
	 * @param model
	 * @return string
	 */
	@RequestMapping(value="/lunchForm",method=RequestMethod.GET)
	public String showForm(Model model) {
		System.out.println("*****lunch Form page*****");
		//create command class object to perform form binding
		StudentCommand studCmd=new StudentCommand();
		return "form_page";
	}

}
