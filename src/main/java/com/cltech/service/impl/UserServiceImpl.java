package com.cltech.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cltech.model.ResponseBean;
import com.cltech.model.Status;
import com.cltech.model.User;
import com.cltech.repository.RoleRepository;
import com.cltech.repository.UserRepository;
import com.cltech.service.UserService;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public String save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
        
        
		return ResponseBean.builder(Status.SUCCESS, "Record Registered Succesfully", user);
    }

    @Override
    public String findByUsername(String username) {
        User userLogin = userRepository.findByUsername(username);
        
        if(userLogin!=null) {
        
        	return ResponseBean.builder(Status.SUCCESS, "Loggedin Succesfully", username);
        }
        
        return ResponseBean.builder(Status.FAIL, "Login Unsuccessful", username);
    }

	@Override
	public String loginAuthentication(User userForm) {
		
		User userLogin = userRepository.findByUsername(userForm.getUsername());
    
    if(userLogin!=null) {
    	
    	if(!userForm.getPassword().equals(userLogin.getPassword())) {
    		
    		return ResponseBean.builder(Status.FAIL, "Password Mismatch", userForm.getUsername());
    	}
    
    	return ResponseBean.builder(Status.SUCCESS, "Loggedin Succesfully", userForm.getUsername());
    }
    
    return ResponseBean.builder(Status.FAIL, "Login Unsuccessful", userForm.getUsername());}
}
