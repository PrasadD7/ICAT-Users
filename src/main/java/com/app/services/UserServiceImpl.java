package com.app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IUserDao;
import com.app.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao dao;
	
	public List<User> getAll(){
		return dao.findAll();		
	}
	
	public User addOne(User u) {
		return dao.save(u);
	}

	

}
