package com.revature.project3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project3.beans.Board;
import com.revature.project3.dao.BoardRepository;

@Service
public class MockitoBoardManagerService {
	@Autowired
	private BoardRepository boardRepo;
	
	public Board addBoard(Board board) {
		return boardRepo.save(board);
	}
	
	public Board findOneBoard(int boardId) {
		return boardRepo.findOne(boardId);
	}
	
	public List<Board> findAllBoards() {
		return (List<Board>) boardRepo.findAll();
	}
	
	public void setBoardRepository (BoardRepository boardRepo) {
		this.boardRepo = boardRepo;
	}
}
