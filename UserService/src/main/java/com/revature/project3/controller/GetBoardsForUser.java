package com.revature.project3.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project3.beans.BoardUserJoin;
import com.revature.project3.service.UserService;

@RestController
public class GetBoardsForUser {

	@Autowired
	UserService userService;

	@GetMapping(path = "/getBoardsForUser/{userId}", produces = "text/plain")
	public ResponseEntity<String> getBoardIds(@PathVariable String userId) {
		int userNum = Integer.parseInt(userId);
		Set<BoardUserJoin> boardSet = userService.getBoardsForUser(userNum);
		String boardList = "";
		for (BoardUserJoin buj : boardSet) {
			if (boardList.length() > 0) {
				boardList += ",";
			}
			boardList += buj.getBoardId();
		}
		return new ResponseEntity<String>(boardList, HttpStatus.OK);
	}
}
