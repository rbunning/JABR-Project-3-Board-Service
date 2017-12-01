package com.revature.project3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project3.beans.Board;
import com.revature.project3.message.BoardMessageSource;
import com.revature.project3.service.BoardManagerService;

@RestController
public class CreateBoardCtrl {
	@Autowired
	BoardManagerService boardManagerService;

	@Autowired
	BoardMessageSource boardMessageSource;

	@PostMapping(path = "/newBoard", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Board> addBoard(@RequestBody Board newBoard) {
		newBoard = boardManagerService.addBoard(newBoard);
		Message<String> msg = MessageBuilder.withPayload(newBoard.toString()).setHeader("Action", "add").build();
		boardMessageSource.boardMessage().send(msg);
		return new ResponseEntity<Board>(newBoard, HttpStatus.OK);
	}
}
