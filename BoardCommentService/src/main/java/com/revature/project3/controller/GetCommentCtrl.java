package com.revature.project3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project3.beans.BoardComment;
import com.revature.project3.service.BoardCommentService;

@RestController
public class GetCommentCtrl {

	@Autowired
	BoardCommentService boardCommentService;

	@GetMapping(path = "/getBoardComment/{commentId}", produces = "application/json")
	public ResponseEntity<BoardComment> getComment(@PathVariable String commentId) {
		int commentNum = Integer.parseInt(commentId);
		return new ResponseEntity<BoardComment>(boardCommentService.getComment(commentNum), HttpStatus.OK);
	}

}
