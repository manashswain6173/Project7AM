package com.usa.federal.gov.ssa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;


@Controller
public class SsnRestClient {
	
	public String url="http://localhost:9092/findState/";
	
	
	@Autowired
	private RestTemplate template;
	
	@RequestMapping(value = "/getState",method = RequestMethod.GET)
	public String getStateBySsn(Model model,HttpServletRequest req) {
		String ssn=null;
		ResponseEntity<Object> stName=null;
		//get parameter value
		ssn=req.getParameter("ssnNo");
		HttpHeaders headers=new HttpHeaders();
		List<MediaType> mediaType=new ArrayList<MediaType>();
		mediaType.add(MediaType.APPLICATION_JSON);
		headers.setAccept(mediaType);
		HttpEntity<String> entity=new HttpEntity<String>(headers);
		try {
			stName=template.exchange(url+ssn, HttpMethod.GET, entity, Object.class);
			System.out.println("---------------"+stName);
		}
		catch(Exception e) {
			System.out.println("-------------------------------------");
			e.getMessage();
		}
		model.addAttribute("stateName","");
		return "result";
	}
	@RequestMapping(value="/home",method = RequestMethod.GET)
	public String index() {
		return "result";
	}

}
