package com.revature.project3.dao;

import org.springframework.data.repository.CrudRepository;

import com.revature.project3.bean.Board;

public interface BoardRepository extends CrudRepository<Board, Integer> {

}
