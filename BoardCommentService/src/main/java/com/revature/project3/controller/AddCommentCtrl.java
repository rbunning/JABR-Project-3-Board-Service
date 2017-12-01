package com.revature.project3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project3.beans.BoardComment;
import com.revature.project3.service.BoardCommentService;

@RestController
public class AddCommentCtrl {

	@Autowired
	BoardCommentService boardCommentService;

	@PostMapping(path = "/newComment", consumes = "application/json", produces = "application/json")
	public ResponseEntity<BoardComment> addBoardComment(@RequestBody BoardComment newBoardComment) {
		return new ResponseEntity<BoardComment>(boardCommentService.addBoardComment(newBoardComment), HttpStatus.OK);
	}
}
