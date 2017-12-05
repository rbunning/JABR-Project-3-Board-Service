package com.revature.project3.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project3.beans.Story;
import com.revature.project3.dao.StoryRepository;

@Service
public class MockitoStoryManagerTestService {
	
	@Autowired
	private StoryRepository storyRepo;
	
	public Story addStory(Story story) {
		return storyRepo.save(story);
	}
	
	public List<Story> findByBoardId(int boardId) {
		return storyRepo.findByBoardId(boardId);
	}
	
	public List<Story> findByBoardIdAndLaneTypeId(int board, int laneType){
		return storyRepo.findByBoardIdAndLaneTypeId(board, laneType);
	}
 
	/* READ */
	// Gets all the stories for a board.
	public List<Story> getListOfStoriesByBoard(Story story) {
		return storyRepo.findByBoardId(story.getBoardId());
	}

	// Gets all the stories in a certain lane for a board.
	public List<Story> getListOfStoriesByBoardAndLaneType(Story story) {
		return storyRepo.findByBoardIdAndLaneTypeId(story.getBoardId(), story.getLaneTypeId());
	}

	// Gets A story by its id.
	public Story getStoryById(int storyId) {
		return storyRepo.findOne(storyId);
	}

	/* Update */
	// Gets the record that need to be updated. Changes the lane type and then saves the change.
	public Story updateStoryByLaneType(Story story) {
		Story dbStory = storyRepo.findOne(story.getStoryId()); // Gets the current record.
		dbStory.setLaneTypeId(story.getLaneTypeId()); // Set the lane to the new lane.
		dbStory.setLastMoveDate(Date.valueOf(LocalDate.now())); // Set date to the date created.
		return storyRepo.save(dbStory);
	}
	
	public void deleteStoryById(Story story) {
		storyRepo.delete(story);
	}
	
	public void setStoryRepository (StoryRepository storyRepo) {
		this.storyRepo = storyRepo;
	}
}
