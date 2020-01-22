package com.app.utils;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.pojos.User;
import com.app.services.IUserService;
import com.app.services.UserServiceImpl;


public class UserUtils {

	
	public User getUserById(int id) {
		
		IUserService svc = new UserServiceImpl();
		
		User usr = new User();
				
		usr = svc.getUserById(id);
		
		return usr;	
	}
}
