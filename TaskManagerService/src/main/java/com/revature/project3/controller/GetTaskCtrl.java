package com.revature.project3.controller;

import java.util.List;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project3.bean.Task;
import com.revature.project3.dao.TaskRepository;

@EnableEurekaClient
@RestController
public class GetTaskCtrl {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	TaskRepository taskRepo;
	
//	@Transactional(readOnly = true)
	@PostMapping("/getTask")
	public Task getTask(@RequestBody Task t) {
		return taskRepo.findOne(t.getTaskId());
	}
	
	@GetMapping("/getTask")
	public Task getTask() {
		return taskRepo.findOne(1);
	}
	
	@GetMapping("/getAllTasks/{storyId}")
	public Iterable<Task> getTasksByStoryId(@RequestBody Iterable<Integer> storyId) {
		
		//Don't know if this will work with Iterable<Integer>
		return taskRepo.findAll(storyId);
	}
	
	@PostMapping("/addTask/{storyId}")
	public Task addTask(int storyId, Task t) {
		t.setStoryId(storyId);
		return taskRepo.save(t);
	}
}
