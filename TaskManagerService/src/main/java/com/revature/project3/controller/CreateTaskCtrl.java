package com.revature.project3.controller;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project3.beans.Task;
import com.revature.project3.dao.TaskRepository;

@RestController
public class CreateTaskCtrl {
	@Autowired
	DataSource dataSource;

	@Autowired
	TaskRepository taskRepo;

	/**
	 * Method to save new task to the database
	 * 
	 * @param newTask
	 * @param request
	 * @return newTask and HttpStatus.OK
	 */
	@PostMapping(path = "/newTask", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Task> addTask(@RequestBody Task newTask, HttpServletRequest request) {
		taskRepo.save(newTask);
		return new ResponseEntity<Task>(newTask, HttpStatus.OK);
	}

}
