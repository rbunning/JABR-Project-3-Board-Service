package com.revature.project3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project3.beans.BoardComment;
import com.revature.project3.dao.BoardCommentRepository;

@Service
public class MockitoBoardCommentService {
	@Autowired
	private BoardCommentRepository commentRepo;
	
	public BoardComment addBoardComment(BoardComment newBoardComment) {
		return commentRepo.save(newBoardComment);
	}
	
	public List<BoardComment> findByboardId(int boardId){
		return commentRepo.findByboardId(boardId);
	};
	
	public void setBoardCommentRepository (BoardCommentRepository boardCommentRepo) {
		this.commentRepo = boardCommentRepo;
	}
}
