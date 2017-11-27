package com.revature.project3.controller;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project3.bean.BoardComment;
import com.revature.project3.dao.BoardCommentRepository;

@RestController
public class AddCommentCtrl {
	@Autowired
	DataSource dataSource;

	@Autowired
	BoardCommentRepository boardCommentRepository;

	@PostMapping(path = "/newComment", consumes = "application/json", produces = "application/json")
	public ResponseEntity<BoardComment> addBoardComment(@RequestBody BoardComment newBoardComment,
			HttpServletRequest request) {
		boardCommentRepository.save(newBoardComment);
		return new ResponseEntity<BoardComment>(newBoardComment, HttpStatus.OK);
	}

}
