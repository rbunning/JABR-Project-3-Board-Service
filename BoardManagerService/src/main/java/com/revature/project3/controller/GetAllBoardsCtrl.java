package com.revature.project3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project3.beans.Board;
import com.revature.project3.service.BoardManagerService;

@RestController
public class GetAllBoardsCtrl {
	@Autowired
	BoardManagerService boardManagerService;

	@GetMapping(path = "/getAllBoards", produces = "application/json")
	public ResponseEntity<List<Board>> getBoards() {
		return new ResponseEntity<List<Board>>(boardManagerService.getBoards(), HttpStatus.OK);
	}

}
