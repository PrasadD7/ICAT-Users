package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Result;
import com.app.services.IResultService;

@RestController
@CrossOrigin
@RequestMapping("/results")
public class ResultController {

	@Autowired
	private IResultService service;
	
	
	@GetMapping
	public ResponseEntity<?> showResults() {
		if(service.getAll()!=null) {
			return new ResponseEntity<List<Result>>(service.getAll(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<?> addResult(@RequestParam int timeTaken, @RequestParam int score,
			@RequestParam int id ){
		try{
			Result result = new Result();
//			UserUtils u = new UserUtils();
			System.out.println("id ="+id);
//			result.setUser(u.getUserById(id));
			result.setScore(score);
			result.setTimeTaken(timeTaken);
			return new ResponseEntity<Result>(service.addOne(result),HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
