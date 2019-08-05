package com.usa.federal.gov.ssa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.usa.federal.gov.ssa.constants.AppsConstantHelper;
import com.usa.federal.gov.ssa.dto.SsnDetailsDTO;
import com.usa.federal.gov.ssa.dto.StateNameDTO;
import com.usa.federal.gov.ssa.exception.SsnWebAppException;
import com.usa.federal.gov.ssa.model.SsnModel;
import com.usa.federal.gov.ssa.service.SSNService;

/**
 * This is the controller class that handle all the request that comes from the
 * client.
 * 
 * @author manash
 *
 */
@Controller
public class SSNWebController {
	/**
	 * Initializing logger object to perform logging operation.
	 */
	private static final Logger LOG = LogManager.getLogger(SSNWebController.class);

	/**
	 * Injecting service class to perform business operation.
	 */
	@Autowired
	private SSNService service;

	/**
	 * This method shows the ssn home link page
	 * 
	 * @return logical view name
	 */
	@RequestMapping(value = AppsConstantHelper.SSN_HOME_URL, method = RequestMethod.GET)
	public String ssnHome() {
		LOG.info("***Controller ssnHome() method is executed sucessfully***");
		return AppsConstantHelper.SSN_LINK_PAGE;
	}

	/**
	 * This method is used to lunch the ssn enrollment form page.
	 * 
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = AppsConstantHelper.SSN_FORM_URL, method = RequestMethod.GET)
	public String ssnFormPage(Model model) {
		LOG.debug("***Controller ssnFormPage() method execution started.***");
		SsnModel ssnMdl = new SsnModel();
		initialForm(model);
		model.addAttribute("ssnmodel", ssnMdl);
		LOG.info("***ssnFormPage() method execution completed sucessfully***");
		return AppsConstantHelper.NEW_SSN_ENROLL_PAGE;
	}

	/**
	 * This method is used to handle the form submission.
	 * 
	 * @param model
	 * @param personDetails
	 * @return String
	 */
	@RequestMapping(value = AppsConstantHelper.FORM_SUBMIT_URL, method = RequestMethod.POST)
	public String enrollFormSumbit(Model model1, @Valid @ModelAttribute("ssnmodel") SsnModel ssnModel,
			BindingResult errors,RedirectAttributes model) {
		String msg = null;
		SsnDetailsDTO dto = null;
		LOG.debug("***enrollFormSubmit() method execution started***");
		if (errors.hasErrors()) {
			initialForm(model);
			LOG.info("***Invalid form data submission***");
			return AppsConstantHelper.NEW_SSN_ENROLL_PAGE;
		}
		dto = new SsnDetailsDTO();
		try {
			BeanUtils.copyProperties(ssnModel, dto);
			msg = service.enrollSSN(dto);
			if (msg != null) {
				model.addFlashAttribute("msg", msg);
			}
			LOG.warn("***Enrollment message is empty***");

		} catch (Exception e) {
			LOG.error("***enrollFormSubmit() method throwing exception***");
			throw new SsnWebAppException(e.getMessage());
		}
		initialForm(model1);
		LOG.info("***enrollFormSubmit() method execution completed sucessfully***");
		return "redirect:"+AppsConstantHelper.SSN_FORM_URL;
	}

	/**
	 * This Method used to handle to show all ssn view request.
	 * 
	 * @param model
	 * @return string
	 */
	@RequestMapping(value = "/allssn", method = RequestMethod.GET)
	public String getAllSSN(Model model) {
		List<SsnDetailsDTO> listDTO = null;
		LOG.debug("***getAllSSN() method execution started***");
		try {
			listDTO = service.getAllSSN();
		} catch (Exception e) {
			LOG.error("getAllSSN() method throwing exception***");
			throw new SsnWebAppException(e.getMessage());
		}
		model.addAttribute("listdto", listDTO);
		LOG.info("***getAllSSN() method execution completed sucessfully***");
		return AppsConstantHelper.ALL_SSN_ENROLL_PAGE;
	}

	/**
	 * This method is used to initialize the form page.
	 * 
	 * @param model
	 */
	public void initialForm(Model model) {
		List<StateNameDTO> dtoList = null;
		List<String> gList = null;
		LOG.debug("***initialForm() method execution started***");
		try {
			gList = new ArrayList<String>(2);
			dtoList = service.getAllState();
			List<String> states = new ArrayList<String>(dtoList.size());
			if (!dtoList.isEmpty()) {
				dtoList.forEach(st -> {
					String str = st.getStateName();
					states.add(str);
				});
			} else
				LOG.warn("***states list is empty***");
			LOG.debug("***state list getted sucessfully");

			gList.add("Male");
			gList.add("Fe-male");
			model.addAttribute("glist", gList);
			model.addAttribute("states", states);
		} catch (Exception e) {
			LOG.error("***initialForm() method throwing exception***");
			throw new SsnWebAppException(e.getMessage());
		}
		LOG.info("***initialForm() method execution completed sucessfully***");
	}

}
