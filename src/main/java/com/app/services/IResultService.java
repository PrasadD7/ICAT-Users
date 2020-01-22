package com.app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.app.pojos.Result;

public interface IResultService {


	public List<Result> getAll();
	
	public Result addOne(Result r);
}
