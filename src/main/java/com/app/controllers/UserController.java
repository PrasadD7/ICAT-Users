package com.app.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.User;
import com.app.services.IUserService;


@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

	@Autowired
	private IUserService service;
	
	@PostConstruct
	public void init() {
		System.out.println("in init "+service);
	}
	
	@GetMapping
	public ResponseEntity<?> getAllUsers(){
		List<User> users = service.getAll();
		if(users==null) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> addUser(@RequestParam String name,@RequestParam String email,@RequestParam String password,@RequestParam String mobileNo){
	try {
		User u =new User(name,email,password,mobileNo);
		return new ResponseEntity<User>(service.addOne(u), HttpStatus.CREATED);
	}
	catch (Exception e) {
		e.printStackTrace();
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
}

