package com.revature.project3.controller;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project3.beans.Task;
import com.revature.project3.dao.TaskRepository;

@EnableEurekaClient
@RestController
public class GetTaskCtrl {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	TaskRepository taskRepo;
	
	/**
	 * Post request that retrieves a specific task from the database that matches taskId
	 * @param t
	 * @return Task
	 */
	
	@PostMapping("/getTask")
	public Task getTask(@RequestBody Task t) {
		return taskRepo.findOne(t.getTaskId());
	}
	
	/**
	 * Get request that retrieves a specific task from the database that matches taskId
	 * @param t
	 * @return Task
	 */
	@GetMapping(path = "/getTask/{taskId}")
	public Task getTask(@PathVariable String taskId) {
		int taskNum = Integer.parseInt(taskId);
		return taskRepo.findOne(taskNum);
	}
	
}
