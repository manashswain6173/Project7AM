package com.manash.service;

import com.manash.model.UserDetails;

public interface UserService {
	
	public UserDetails getUser();
	
	public String addUser(UserDetails details);
	
	public UserDetails searchUser();

}
