package com.revature.project3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project3.beans.BoardComment;
import com.revature.project3.service.BoardCommentService;

@RestController
public class GetCommentsForBoardCtrl {

	@Autowired
	BoardCommentService boardCommentService;

	@GetMapping(path = "/getCommentsForBoard/{boardId}", produces = "application/json")
	public ResponseEntity<List<BoardComment>> getCommentsOnBoard(@PathVariable String boardId) {
		int boardNum = Integer.parseInt(boardId);
		return new ResponseEntity<List<BoardComment>>(boardCommentService.getCommentsOnBoard(boardNum), HttpStatus.OK);
	}

}
