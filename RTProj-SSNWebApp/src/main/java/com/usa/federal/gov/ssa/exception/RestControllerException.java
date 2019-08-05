package com.usa.federal.gov.ssa.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class RestControllerException {

	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<Object> handleNoDataFoundException(){
		RestErrorMsg error=new RestErrorMsg();
		error.setErrorCode(400);
		error.setDesc("No Data found..Enter a validate SSN number!!");
		error.setDate(new Date());
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
}
