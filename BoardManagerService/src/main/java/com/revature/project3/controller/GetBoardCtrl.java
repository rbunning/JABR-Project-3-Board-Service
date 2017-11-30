package com.revature.project3.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project3.beans.Board;
import com.revature.project3.service.BoardManagerService;

@RestController
public class GetBoardCtrl {
	@Autowired
	BoardManagerService boardManagerService;

	@GetMapping(path = "/getBoard/{boardId}", produces = "application/json")
	public ResponseEntity<Board> getBoard(@PathVariable String boardId, HttpServletRequest request) {
		int boardNum = Integer.parseInt(boardId);
		return new ResponseEntity<Board>(boardManagerService.getBoard(boardNum), HttpStatus.OK);
	}

}
