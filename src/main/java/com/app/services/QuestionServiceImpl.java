package com.app.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IQuestionDao;
import com.app.pojos.*;
import java.util.*;

@Service
@Transactional
public class QuestionServiceImpl implements IQuestionService {

	@Autowired
	private IQuestionDao dao;
	
	public List<Question> getAll(){
		return dao.findAll();
	}
}
