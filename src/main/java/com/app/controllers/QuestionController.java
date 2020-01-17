package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.pojos.*;

import com.app.services.IQuestionService;

@RestController
@CrossOrigin
@RequestMapping("/questions")
public class QuestionController {

	@Autowired
	private IQuestionService service;
	
	@GetMapping
	public ResponseEntity<?> getQuestions(){
		List<Question> questions = service.getAll();
		if(questions==null) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Question>>(questions,HttpStatus.OK);

	}
}
