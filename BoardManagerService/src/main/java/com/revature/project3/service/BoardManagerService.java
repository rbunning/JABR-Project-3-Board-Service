package com.revature.project3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project3.beans.Board;
import com.revature.project3.dao.BoardRepository;

@Service(value = "AppBoardManagerService")
public class BoardManagerService {

	@Autowired
	BoardRepository boardRepository;

	public Board addBoard(Board newBoard) {
		return boardRepository.save(newBoard);
	}
	
	public List<Board> getBoards() {
		return (List<Board>) boardRepository.findAll();
	}

	public Board getBoard(int boardNum) {
		return boardRepository.findOne(boardNum);
	}
	
	public List<Board> getBoardList(ArrayList<Integer> boardIdList) {
		return boardRepository.findByboardIdIn(boardIdList);
	}
}
