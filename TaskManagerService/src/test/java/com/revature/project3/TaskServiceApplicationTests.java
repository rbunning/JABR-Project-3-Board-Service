package com.revature.project3;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.project3.beans.Task;
import com.revature.project3.dao.TaskRepository;
import com.revature.project3.service.LogsService;

//Regular Unit tests
@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskServiceApplicationTests {

	@Autowired
	TaskRepository taskRepo;
	
	@Autowired
	LogsService logsService;
	
	Task testTask = new Task(1,1,null);
	
	@Test
	public void testTaskById() {
		assertNotNull(taskRepo.findOne(testTask.getTaskId()));
	}
	
	@Test
	public void testTasksByStoryId() {
		assertNotNull(taskRepo.findBystoryId(testTask.getStoryId()));
	}
	
	@Test
	public void testAllLogs() {
		assertNotNull(logsService.getAllLogs());
	}
	
	@Test
	public void contextLoads() {
	}

}
