package com.revature.project3.controller;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project3.bean.BoardComment;
import com.revature.project3.dao.BoardCommentRepository;

@RestController
public class GetCommentCtrl {

	@Autowired
	DataSource dataSource;

	@Autowired
	BoardCommentRepository boardCommentRepository;

	@GetMapping(path = "/getBoardComment/{commentId}", produces = "application/json")
	public ResponseEntity<BoardComment> getComment(@PathVariable String commentId, HttpServletRequest request) {
		int commentNum = Integer.parseInt(commentId);
		BoardComment comment = boardCommentRepository.findOne(commentNum);
		return new ResponseEntity<BoardComment>(comment, HttpStatus.OK);
	}

}
