package com.usa.federal.gov.ssa.exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
@ControllerAdvice
public class SSNWeAppExceptionHandler {
	
	@ExceptionHandler(SsnWebAppException.class)
	public String handleNullPointException(Model model) {
		model.addAttribute("errMsg", "Some problems occur in the application,please try after some time..!!!");
		return "errorPage";
	}
}
