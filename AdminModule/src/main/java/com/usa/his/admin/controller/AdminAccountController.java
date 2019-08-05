package com.usa.his.admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.usa.his.admin.dto.AdminDTO;
import com.usa.his.admin.model.AdminModel;
import com.usa.his.admin.service.AdminAccountService;

@Controller
public class AdminAccountController {

	/**
	 * Initializing logger object to perform logging operation.
	 */
	private static final Logger LOG = LogManager.getLogger(AdminAccountController.class);
	/**
	 * Injecting service class to perform business operation.
	 */
	@Autowired
	private AdminAccountService service;

	/**
	 * This method is used to lunch admin account registration form page.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String lunchRegForm(Model model) {
		LOG.info("***adminAccountReg() method execution started***");
		AdminModel admin = new AdminModel();
		model.addAttribute("admin", admin);
		return "adminAccRegForm";
	}

	@ModelAttribute(name = "rolesList")
	public List<String> displayAllRoles() {
		return service.getAllRoles();
	}

	@ModelAttribute(name = "genderList")
	public List<String> initialGendeList() {
		List<String> glist = new ArrayList<String>();
		glist.add("Male");
		glist.add("Fe-Male");
		return glist;
	}

	@RequestMapping(value = "/submitForm", method = RequestMethod.POST)
	public String submitRegForm(RedirectAttributes model, @ModelAttribute("admin") AdminModel admin) {
		AdminDTO dto = null;
		String msg = null;
		LOG.info("****submitRegForm() method execution startedd****");
		try {
			if (admin != null) {
				LOG.debug("***Coping data form admin to dto class object");
				dto = new AdminDTO();
				BeanUtils.copyProperties(admin, dto);
			}
			msg = service.createAdminAccount(dto);
			if (msg != null) {
				LOG.debug("***Keeping model data into model attribute***");
				model.addFlashAttribute("msg", msg);
				// model.addAttribute("admin", new AdminModel());
			}
		} catch (Exception e) {
			LOG.error("***submitRegForm() method throws exception***");
			e.printStackTrace();
		}
		LOG.info("***submitRegForm() method execution completed***");
		return "redirect:/form";
	}

	@RequestMapping(value = "/getAllAdmin", method = RequestMethod.GET)
	public String viewAllAdminDetails(Model model) {
		LOG.info("***viewAllAdminDetails() method execution started***");
		return null;

	}

	@RequestMapping(value = "/checkEmail", method = RequestMethod.GET)
	public @ResponseBody String checkEmailAvailablity(HttpServletRequest req, Model model) {
		String emailId = null;
		LOG.info("***checkEmailAvailablity() method execution started****");
		emailId = req.getParameter("email");
		//return (service.checkEmailAvailablity(emailId)) ? "available" : "not-available";
		return service.checkEmailAvailablity(emailId);
	}

}
