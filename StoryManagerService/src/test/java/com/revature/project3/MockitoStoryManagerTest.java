package com.revature.project3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.same;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.project3.beans.Story;
import com.revature.project3.dao.StoryRepository;
import com.revature.project3.service.MockitoStoryManagerTestService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StoryServiceApplication.class)
public class MockitoStoryManagerTest {
	@Autowired
	private MockitoStoryManagerTestService mockStoryService;

	@Autowired
	private StoryRepository mockStoryRepo;

	@Before
	public void initialize() {
		mockStoryService = new MockitoStoryManagerTestService();
		mockStoryRepo = mock(StoryRepository.class);
		mockStoryService.setStoryRepository(mockStoryRepo);
	}
	
	@Test
	public void addStory() {
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		Story testStory = new Story(1, 1, "new story", 5, "for testing", date);
		when(mockStoryRepo.save(same(testStory))).thenReturn(testStory);
		Story returnedStory = mockStoryService.addStory(testStory);
		assertEquals(testStory, returnedStory);
	}
	
	@Test
	public void getListOfStoriesByBoardId() {
		List<Story> testStories = null;
		when(mockStoryRepo.findByBoardId(1)).thenReturn(testStories);
		List<Story> returnedStories = mockStoryService.findByBoardId(1);
		assertEquals(testStories, returnedStories);
	}
	
	@Test
	public void getListOfStoriesByBoardIdAndLaneTypeId() {
		List<Story> testStories = null;
		when(mockStoryRepo.findByBoardIdAndLaneTypeId(1,1)).thenReturn(testStories);
		List<Story> returnedStories = mockStoryService.findByBoardIdAndLaneTypeId(1,1);
		assertEquals(testStories, returnedStories);
	}
}
