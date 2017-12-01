package com.revature.project3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project3.dto.BoardUserDto;
import com.revature.project3.service.UserService;

@RestController
public class AddUserToBoard {

	@Autowired
	UserService userService;

	@PostMapping(path = "/addUserToBoard", consumes = "application/json")
	public void addUser(@RequestBody BoardUserDto boardUserDto) {
		userService.addUser(boardUserDto);
	}

}
