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

import com.revature.project3.beans.BoardComment;
import com.revature.project3.dao.BoardCommentRepository;
import com.revature.project3.service.MockitoBoardCommentService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BoardCommentServiceApplication.class)
public class MockitoBoardCommentTest {
	@Autowired
	private MockitoBoardCommentService mockCommentTestService;
	
	@Autowired
	private BoardCommentRepository mockCommentRepo;
	
	@Before
	public void initialize() {
		mockCommentTestService = new MockitoBoardCommentService();
		mockCommentRepo = mock(BoardCommentRepository.class);
		mockCommentTestService.setBoardCommentRepository(mockCommentRepo);
	}
	
	@Test
	public void testAddBoard() {
		BoardComment testComment = new BoardComment(1, 1, "for testing");
		when(mockCommentRepo.save(same(testComment))).thenReturn(testComment);
		BoardComment returnedComment = mockCommentTestService.addBoardComment(testComment);
		assertEquals(testComment, returnedComment);
	}
	
	@Test
	public void testFindCommentsByBoardId() {
		List<BoardComment> testComments = null;
		when(mockCommentRepo.findByboardId(1)).thenReturn(testComments);
		List<BoardComment> returnedComments = mockCommentTestService.findByboardId(1);
		assertEquals(testComments, returnedComments);
	}
}
