package com.revature.project3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project3.beans.Story;
import com.revature.project3.service.StoryService;

@RestController
public class UpdateStoryCtrl {
	
	@Autowired
	StoryService service;
	
	// This used a key pair to send the lane type to the service.
	@PostMapping("/StoryLane")
	public Story UpdateStoryLane(Story story) {
		return service.updateStoryByLaneType(story);
	}
	
	// This used the url to send a lane type to the service.
	@PostMapping("/StoryLane/{lane}")
	public Story UpdateStoryLane2(Story story, @PathVariable String lane) {
		story.setLaneType(Integer.parseInt(lane));
		return service.updateStoryByLaneType(story);
	}
}
