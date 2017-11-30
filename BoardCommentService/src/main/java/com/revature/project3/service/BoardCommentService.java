package com.revature.project3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project3.beans.BoardComment;
import com.revature.project3.dao.BoardCommentRepository;

@Service(value = "AppBoardCommentService")
public class BoardCommentService {

	@Autowired
	BoardCommentRepository boardCommentRepository;

	public BoardComment addBoardComment(BoardComment newBoardComment) {
		return boardCommentRepository.save(newBoardComment);
	}
	
	public List<BoardComment> getComments() {
		List<BoardComment> commentList = (List<BoardComment>) boardCommentRepository.findAll();
		return commentList;
	}
	
	public BoardComment getComment(int commentNum) {
		return boardCommentRepository.findOne(commentNum);
	}

	public List<BoardComment> getCommentsOnBoard(int boardNum) {
		return boardCommentRepository.findByboardId(boardNum);
	}
}
