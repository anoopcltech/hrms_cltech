package com.cltech.service;

import com.cltech.model.User;

public interface UserService {
   
	String save(User user);
	String findByUsername(String username);
	String loginAuthentication(User userForm);
}
