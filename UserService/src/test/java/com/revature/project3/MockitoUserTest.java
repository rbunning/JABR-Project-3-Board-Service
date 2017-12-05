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

import com.revature.project3.beans.ScrumUser;
import com.revature.project3.dao.ScrumUserRepository;
import com.revature.project3.service.MockitoUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UserServiceApplication.class)
public class MockitoUserTest {
	@Autowired
	private MockitoUserService mockUserService;
	
	@Autowired
	private ScrumUserRepository mockUserRepo;
	
	@Before
	public void initialize() {
		mockUserService = new MockitoUserService();
		mockUserRepo = mock(ScrumUserRepository.class);
		mockUserService.setUserRepo(mockUserRepo);
	}
	
	@Test
	public void testFindUserByJoinId() {
		List<ScrumUser> testUsers = null;
		when(mockUserRepo.findByboardUserJoins_boardId(1)).thenReturn(testUsers);
		List<ScrumUser> returnedUsers = mockUserService.findByboardUserJoins_boardId(1);
		assertEquals(testUsers, returnedUsers);
		
	}
	
	@Test
	public void testFindUserByUsername() {
		List<ScrumUser> testUsers = null;
		when(mockUserRepo.findByscrumUserUsername("scrum")).thenReturn(testUsers);
		List<ScrumUser> returnedUsers = mockUserService.findUserByUsername("scrum");
		assertEquals(testUsers, returnedUsers);
	}
	
//	public void testFindCommentsByBoardId() {
//		List<BoardComment> testComments = null;
//		when(mockCommentRepo.findByboardId(1)).thenReturn(testComments);
//		List<BoardComment> returnedComments = mockCommentTestService.findByboardId(1);
//		assertEquals(testComments, returnedComments);
//	}
	
}
