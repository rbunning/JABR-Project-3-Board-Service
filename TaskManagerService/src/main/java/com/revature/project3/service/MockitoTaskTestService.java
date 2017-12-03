package com.revature.project3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project3.beans.Task;
import com.revature.project3.dao.TaskRepository;

@Service
public class MockitoTaskTestService {
	
	@Autowired
	private TaskRepository taskRepo;
	
	public List <Task> findBystoryId (int storyId) {
		return taskRepo.findBystoryId(storyId);
	}
	
	public Task findOne (int taskId) {
		return taskRepo.findOne(taskId);
	}
	
	public Task saveTask (Task task) {
		return taskRepo.save(task);
	}
	
	//This will be used for mockito/unit test
	public void setTaskRepository (TaskRepository taskRepo) {
		this.taskRepo = taskRepo;
	}
}
