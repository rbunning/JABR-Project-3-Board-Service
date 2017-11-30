package com.revature.project3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project3.beans.ScrumUser;
import com.revature.project3.service.UserService;

@RestController
public class LoginCtrl {

	@Autowired
	UserService userService;

	@PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ScrumUser> loginUser(@RequestBody ScrumUser userLogin) {
		return new ResponseEntity<ScrumUser>(userService.loginUser(userLogin), HttpStatus.OK);
	}
}
