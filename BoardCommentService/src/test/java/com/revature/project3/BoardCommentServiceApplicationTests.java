package com.revature.project3;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.project3.beans.BoardComment;
import com.revature.project3.service.BoardCommentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardCommentServiceApplicationTests {

	@Autowired
	BoardCommentService boardCommentService;

	BoardComment testBoardComment = new BoardComment(1, 1, 2, "Created Board", "2017-11-27 12:00:01");
	
	@Test
	public void testGetComment() {
		assertNotNull(boardCommentService.getComment(testBoardComment.getBoardCommentId()));
	}

	@Test
	public void testGetCommentsOnBoard() {
		assertNotNull(boardCommentService.getCommentsOnBoard(testBoardComment.getBoardId()));
	}

	@Test
	public void testGetComments() {
		assertNotNull(boardCommentService.getComments());
	}
}
