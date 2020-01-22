package com.app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IResultDao;
import com.app.pojos.Result;

@Service
@Transactional
public class ResultServiceImpl implements IResultService {

	@Autowired
	private IResultDao dao;
	
	@Override
	public List<Result> getAll() {

		return dao.findAll();
	}

	@Override
	public Result addOne(Result r) {
		Result res = new Result();
		res.setScore(r.getScore());
		res.setTimeTaken(r.getTimeTaken());
		return dao.save(res);
	}
	
	

}
