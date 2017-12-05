package com.revature.project3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.same;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.project3.beans.Task;
import com.revature.project3.dao.TaskRepository;
import com.revature.project3.service.MockitoTaskTestService;

//Unit Tests with Mockito
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TaskServiceApplication.class)
public class MockitoTaskTests {
	
	@Autowired
	private MockitoTaskTestService mockTaskService;
	
	@Autowired
	private TaskRepository mockTaskRepo;
	
	@Before
	public void initialize() {
		mockTaskService = new MockitoTaskTestService();
		mockTaskRepo = mock(TaskRepository.class);
		mockTaskService.setTaskRepository(mockTaskRepo);
	}
	
	@Test
	public void testTaskById() {
		Task testTask = new Task(1,1,"Configure ORM");
		when(mockTaskRepo.findOne(testTask.getTaskId())).thenReturn(testTask);
		Task returnedTask = mockTaskService.findOne(testTask.getTaskId());
		assertEquals(testTask, returnedTask);
	}
	
	@Test
	public void testTaskSave() {
		Task testTask = new Task(200, 28, "This task is meant for testing mockito!");
		when(mockTaskRepo.save(same(testTask))).thenReturn(testTask);
		Task returnedTask = mockTaskService.saveTask(testTask);
		assertEquals(testTask, returnedTask);
	}
	
	@Test
	public void testTaskByStoryId() {
		int testStoryId = 28;
		List <Task> testTasks = null;
		when(mockTaskRepo.findBystoryId(testStoryId)).thenReturn(testTasks);
		List <Task> returnedTasks = mockTaskService.findBystoryId(testStoryId);
		assertEquals(testTasks, returnedTasks);
	}
	
}
