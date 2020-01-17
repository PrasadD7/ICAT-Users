package com.app.services;

import java.util.List;

import com.app.pojos.User;

public interface IUserService {

	public List<User> getAll();
	
	public User addOne(User u);
	
}
