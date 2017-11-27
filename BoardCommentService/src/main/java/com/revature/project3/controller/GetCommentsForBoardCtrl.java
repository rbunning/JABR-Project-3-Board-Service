package com.revature.project3.controller;

import java.util.List;

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
public class GetCommentsForBoardCtrl {

	@Autowired
	DataSource dataSource;

	@Autowired
	BoardCommentRepository boardCommentRepository;

	@GetMapping(path = "/getCommentsForBoard/{boardId}", produces = "application/json")
	public ResponseEntity<List<BoardComment>> getCommentsOnBoard(@PathVariable String boardId,
			HttpServletRequest request) {
		int boardNum = Integer.parseInt(boardId);
		List<BoardComment> commentList = boardCommentRepository.findByboardId(boardNum);
		return new ResponseEntity<List<BoardComment>>(commentList, HttpStatus.OK);
	}

}
