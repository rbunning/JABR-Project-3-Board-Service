package com.revature.project3;

import static org.junit.Assert.assertEquals;
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

import com.revature.project3.beans.Board;
import com.revature.project3.dao.BoardRepository;
import com.revature.project3.service.MockitoBoardManagerService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BoardServiceApplication.class)
public class MockitoBoardManagerTest {
	
	@Autowired
	private BoardRepository mockBoardRepo;
	
	@Autowired
	private MockitoBoardManagerService mockBoardService;
	
	@Before
	public void initialize() {
		mockBoardService = new MockitoBoardManagerService();
		mockBoardRepo = mock(BoardRepository.class);
		mockBoardService.setBoardRepository(mockBoardRepo);
	}
	
	@Test
	public void testAddBoard() {
		Board testBoard = new Board("Test baord");
		when(mockBoardRepo.save(same(testBoard))).thenReturn(testBoard);
		Board returnedBoard = mockBoardService.addBoard(testBoard);
		assertEquals(testBoard, returnedBoard);
	}
	
	@Test
	public void testFindByBoardId() {
		Board testBoard = null;
		when(mockBoardRepo.findOne(1)).thenReturn(testBoard);
		Board returnedBoard = mockBoardService.findOneBoard(1);
		assertEquals(testBoard, returnedBoard);
	}
	
	@Test
	public void testFindAllBoards() {
		List<Board> testBoards = null;
		when(mockBoardRepo.findAll()).thenReturn(testBoards);
		List<Board> returnedBoards = mockBoardService.findAllBoards();
		assertEquals(testBoards, returnedBoards);
	}
}
