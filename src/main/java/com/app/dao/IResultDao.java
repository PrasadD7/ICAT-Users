package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Result;

public interface IResultDao extends JpaRepository<Result, Integer> {

}
