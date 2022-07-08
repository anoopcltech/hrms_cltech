package com.cltech.service;

import com.cltech.model.User;

public interface UserService {
   
	void save(User user);
    User findByUsername(String username);
}
