package com.manash.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingErrorProcessor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manash.command.StudentCommand;
import com.manash.config.AppsMsg;
import com.manash.constants.AppsContstants;
import com.manash.dto.StudentDTO;
import com.manash.service.StudentService;

@Controller
public class StudentRegController {
	
	@Autowired
	private StudentService service;
	@Autowired
	private AppsMsg appmsg;

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
		initalizeForm(model);
		model.addAttribute("studCmd", studCmd);
		return AppsContstants.LOGICAL_NAME;
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String submitForm(Model model,  @Valid @ModelAttribute("studCmd")  StudentCommand studCmd,BindingResult errors) {
		StudentDTO dto=null;
		//convert command object data to dto object
		dto=new StudentDTO();
		if(errors.hasErrors()) {
			initalizeForm(model);
			return AppsContstants.LOGICAL_NAME;
		}
		//copy properties from command object to dto object
	    BeanUtils.copyProperties(studCmd, dto);
	    //invoke service class methods to perform business operations
	    dto=service.regStudent(dto);
	    //convert dto object to entity object
	    StudentCommand command=new StudentCommand();
	    BeanUtils.copyProperties(dto, command);
	    //pass resultant object to view layer
	    if(dto!=null) {
	    	model.addAttribute("msg",appmsg.getMsgs().get(AppsContstants.SUCC_MSG));
	    	model.addAttribute("result", command);
	    	model.addAttribute("profile", appmsg.getMsgs().get("profile"));
	    }
	    else
	    	model.addAttribute("msg", appmsg.getMsgs().get(AppsContstants.FAIL_MSG));
	    	
		/* model.addAttribute("studCmd", new StudentCommand()); */
	    initalizeForm(model);
		return AppsContstants.LOGICAL_NAME;
	}
	
	public void initalizeForm(Model model) {
		//create array object to store genders 
				List<String> gList=new ArrayList<String>();
				gList.add("M");gList.add("F");
				//set courses to array list 
				List<String> courseList=new ArrayList<String>();
				courseList.add("Java");courseList.add("Oracel");
				courseList.add("UI");courseList.add("Python");
				//add objects to model attribute
				model.addAttribute("gList", gList);
				model.addAttribute("couresList", courseList);
	}
}
