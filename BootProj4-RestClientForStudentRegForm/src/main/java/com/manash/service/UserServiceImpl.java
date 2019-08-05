package com.manash.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.manash.model.UserDetails;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	//create url 
	String url1="http://localhost:9091/user";
	String url2="http://localhost:9091/addUser";
	
	@Autowired
	private RestTemplate template;
	
	@Autowired
	private WebClient client;

	@Override
	public UserDetails getUser() {
		ResponseEntity<UserDetails> entity=null;
		entity=template.getForEntity(url1, UserDetails.class);
		return entity.getBody();
	}
	
	@Override
	public String addUser(UserDetails details) {
		
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_XML);
		
		HttpEntity<String> reqEntity=new HttpEntity(details,headers);
        ResponseEntity<String> resEntity=template.exchange(url2, HttpMethod.POST, reqEntity, String.class);
		System.out.println(resEntity.getBody());
		System.out.println(resEntity.getStatusCode());
		return resEntity.getBody();
	}
	
	@Override
	public UserDetails searchUser() {
		//add url  to client
		UserDetails response=client.get()
				.uri("/user")
				.retrieve()
				.bodyToMono(UserDetails.class)
				.block();
		return response;
	}

}
