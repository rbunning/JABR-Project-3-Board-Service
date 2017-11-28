package com.revature.project3.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project3.bean.ScrumUser;
import com.revature.project3.dao.ScrumUserRepository;

@EnableResourceServer 
@RestController
public class GetAllUsersNotOnBoard {

	@Autowired
	DataSource dataSource;

	@Autowired
	ScrumUserRepository scrumUserRepository;

	@GetMapping(path = "/getAllUsersNotOnBoard/{boardId}", produces = "application/json")
	public ResponseEntity<List<ScrumUser>> getAllUsersOnBoard(@PathVariable String boardId, HttpServletRequest request) {
		int boardNum = Integer.parseInt(boardId);
		List<ScrumUser> scrumUserListOnBoard = scrumUserRepository.findByboardUserJoins_boardId(boardNum);
		List<ScrumUser> scrumUserList = (List<ScrumUser>) scrumUserRepository.findAll();
		for (ScrumUser su : scrumUserListOnBoard) {
			scrumUserList.remove(su);
		}
		return new ResponseEntity<List<ScrumUser>>(scrumUserList, HttpStatus.OK);
	}
}
