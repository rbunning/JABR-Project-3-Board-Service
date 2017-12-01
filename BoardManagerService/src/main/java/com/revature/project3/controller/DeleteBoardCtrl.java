package com.revature.project3.controller;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project3.beans.Board;
import com.revature.project3.dao.BoardRepository;

@RestController
public class DeleteBoardCtrl {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	BoardRepository boardRepo;
	
	@PostMapping(path="/deleteBoard", consumes="application/json")
	public ResponseEntity<Void> deleteBoard(
			@RequestBody
			Board board,
			HttpServletRequest
			request
			) {
		
		boardRepo.delete(board);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
	}
}
