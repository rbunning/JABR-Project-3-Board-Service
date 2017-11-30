package com.revature.project3.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.revature.project3.beans.Board;

public interface BoardRepository extends CrudRepository<Board, Integer> {

	List<Board> findByboardIdIn(ArrayList<Integer> boardList);
}
