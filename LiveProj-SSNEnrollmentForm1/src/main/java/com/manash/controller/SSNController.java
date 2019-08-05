package com.manash.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manash.command.PersonDetailsCommand;
import com.manash.constants.AppsConstant;
import com.manash.dto.SSNPersonDetailsDTO;
import com.manash.service.SSNService;
/**
 * This is the controller class, it handles all the request that comes from the client.
 * @author manas
 *
 */

@Controller
public class SSNController {
	
	@Autowired
	private SSNService service;
	
	/**
	 * This Method lunches the new SSN Enrollment Hyper link
	 * @return String
	 */
	@RequestMapping(value = "/home",method=RequestMethod.GET)
	public String home() {
		return AppsConstant.SSN_LINK_PAGE;
	}
	/**
	 * This Method lunches the SSN form page for Enrollment
	 * @param model
	 * @return String
	 */
	@RequestMapping(value="/enrollment",method=RequestMethod.GET)
	public String ssnEnrollmentForm(Model model) {
		PersonDetailsCommand details =null;
		//create command class object to send to view layer for form binding
				details=new PersonDetailsCommand();
			    //put command class object into model attribute to send into view layer
				model.addAttribute("personDetails", details);
		  //invoke initialFormpage method
		initalFormPage(model);
		
		return AppsConstant.NEW_SSN_ENROLL_PAGE;//returns the logical view name to controller
	}
	/**
	 * This method is used to handle the form submission.
	 * @param model
	 * @param personDetails
	 * @return String
	 */
	@RequestMapping(value="/submitSSN",method=RequestMethod.POST)
	public String enrollFormSumbit(Model model,
			                  @Valid @ModelAttribute("personDetails") PersonDetailsCommand personDetails,
			                  BindingResult error) {
		String msg = null;
		SSNPersonDetailsDTO dto = null;
		// convert model data to dto
		dto=new SSNPersonDetailsDTO();
	    BeanUtils.copyProperties(personDetails, dto);
		//use service class to insert data 
	    msg=service.enrollSSN(dto);
	    model.addAttribute("msg",msg);
	    initalFormPage(model);
		return AppsConstant.NEW_SSN_ENROLL_PAGE;//returns the logical view name to controller
	}
	/**
	 * This Method used to handle to show all ssn view request.
	 * @param model
	 * @return string
	 */
	@RequestMapping(value="/allssn",method=RequestMethod.GET)
	public String getAllSSN(Model model) {
		List<SSNPersonDetailsDTO> listDTO=null;
		//invoke service class method
		listDTO=service.getAllSSN();
		//keep all the ssn into model scope
		model.addAttribute("listdto", listDTO);
		return AppsConstant.ALL_SSN_ENROLL_PAGE;
	}
	
	
	/**
	 * This Method is used to initialize the form.
	 * @param model
	 */
	public void initalFormPage(Model model) {
		
		List<String> gList=null,stateList=null;
	   
		//pass  some initial data to view layer
		gList=new ArrayList<String>();
		gList.add("Male");gList.add("Fe-Male");
		model.addAttribute("glist", gList);
	
		stateList=new ArrayList<String>();
		stateList.add("--state--");
		stateList.add("Alabama");stateList.add("Alaska");
		stateList.add("Arizona");stateList.add("Arkansas");
		stateList.add("California");stateList.add("Colorado");
		model.addAttribute("statelist", stateList);
		model.addAttribute("personDetails", new PersonDetailsCommand());
	}
}
