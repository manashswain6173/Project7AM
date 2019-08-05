package com.manash.resources;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.manash.binding.UserAddress;
import com.manash.binding.UserDetails;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
public class UserRestResource {
	
	public static Map<Integer,Object> map=new HashMap<Integer,Object>();
	
	@GetMapping(value="/rest")
	public String welcomeUser(@RequestParam(name="name") String name) {
		return name+" welcome to RestFull Services";
	}
	@GetMapping(value="/wish/{name}")
	public String wishUser(@PathVariable("name") String name) {
		return "Good Morning ,"+name;
	}
	@GetMapping(value="/user")
	@ApiOperation(value = "Gives the user details")
	public @ResponseBody UserDetails getUser() {
		//create user details object
		UserDetails user=new UserDetails();
		user.setId(101);
		user.setFName("John");
		user.setLName("das");
		//create address object
		UserAddress addr=new UserAddress();
		addr.setHouseNo(175);
		addr.setStreet("SR Nager");
		addr.setState("Telengana");
		addr.setCountry("India");
		addr.setZipCode(500038);
		user.setAddress(addr);
		user.setMobileNo(null);
		user.setEMail("gmail.com");
		return user;
	}
	@PostMapping(value="/addUser",
			     consumes= {"application/xml","application/json"})
	public @ResponseBody String addUser(@RequestBody UserDetails details) {
		map.put(details.getId(), details);
		System.out.println(map);
		return "User Details added Succesfully";
		
	}

}

