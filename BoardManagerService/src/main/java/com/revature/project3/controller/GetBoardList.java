package com.revature.project3.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project3.beans.Board;
import com.revature.project3.service.BoardManagerService;

@RestController
public class GetBoardList {
	@Autowired
	BoardManagerService boardManagerService;

	@PostMapping(path = "/getBoards", consumes = "application/json", produces = "application/json")
	public ResponseEntity<List<Board>> getBoardList(@RequestBody String boardIds) {
		List<String> boardIdStringList = new ArrayList<String>(Arrays.asList(boardIds.split(",")));
		ArrayList<Integer> boardIdList = new ArrayList<Integer>();
		for (String boardId : boardIdStringList) {
			boardIdList.add(Integer.parseInt(boardId.trim()));
		}
		return new ResponseEntity<List<Board>>(boardManagerService.getBoardList(boardIdList), HttpStatus.OK);
	}

}
