package com.revature.project3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project3.beans.ScrumUser;
import com.revature.project3.service.UserService;

@RestController
public class GetAllUsersCtrl {

	@Autowired
	UserService userService;

	@GetMapping(path = "/getAllUsers", produces = "application/json")
	public ResponseEntity<List<ScrumUser>> getUsers() {
		return new ResponseEntity<List<ScrumUser>>(userService.getUsers(), HttpStatus.OK);
	}
}
