package com.revature.project3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.project3.beans.Story;
import com.revature.project3.dao.StoryRepository;

public class StoryService {
	
	@Autowired
	StoryRepository StoryRepo;
	
	// CREATE
	public void addStory() {
		
	}
	
	
	// READ
	public List<Story> getListOfStoriesByBoard(Story story) {
		return StoryRepo.findByBoard(story.getBoard());
	}
	
	public List<Story> getListOfStoriesByBoardAndLaneType(Story story) {
		return StoryRepo.findByBoardAndLaneType(story.getBoard(), story.getLaneType());
	}
	
	public Story getStoryById(Story story) {
		return StoryRepo.findOne(story.getStoryId());
	}
}
