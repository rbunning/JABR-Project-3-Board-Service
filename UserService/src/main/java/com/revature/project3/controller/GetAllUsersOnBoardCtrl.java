package com.revature.project3.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project3.beans.ScrumUser;
import com.revature.project3.service.UserService;

@RestController
public class GetAllUsersOnBoardCtrl {

	@Autowired
	UserService userService;

	@GetMapping(path = "/getAllUsersForBoard/{boardId}", produces = "application/json")
	public ResponseEntity<List<ScrumUser>> getAllUsersOnBoard(@PathVariable String boardId,
			HttpServletRequest request) {
		int boardNum = Integer.parseInt(boardId);
		return new ResponseEntity<List<ScrumUser>>(userService.getAllUsersOnBoard(boardNum), HttpStatus.OK);
	}
}
