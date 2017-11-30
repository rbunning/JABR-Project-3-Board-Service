package com.revature.project3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project3.beans.Story;
import com.revature.project3.service.StoryService;

@EnableResourceServer
@RestController
public class GetStoryCtrl {
	
	@Autowired
	StoryService service;
	
	@GetMapping("/allboardStories/{board}")
	public List<Story> getAllStoriesByBoard(@PathVariable String board) {
		return service.getListOfStoriesByBoard(new Story(Integer.parseInt(board), 0, null, 0, null, null));
	}
	
	// Gets all the stories within a board in certain lane using key value pairs.
	@PostMapping("/allStories")
	public List<Story> getAllStories(@RequestBody Story story) {
		return service.getListOfStoriesByBoardAndLaneType(story);
	}
	
	// Gets all the stories within a board in certain lane with lane as part of path.
	@PostMapping("/allStories/{lane}")
	public List<Story> getAllStories2(@RequestBody Story story, @PathVariable String lane) {
		story.setLaneType(Integer.parseInt(lane));
		return service.getListOfStoriesByBoardAndLaneType(story);
	}
	
	// Gets a single story by Id.
	@GetMapping("/story/{id}")
	public Story getStory(@PathVariable String id) {
		return service.getStoryById(new Story(Integer.parseInt(id)));
	}
}
