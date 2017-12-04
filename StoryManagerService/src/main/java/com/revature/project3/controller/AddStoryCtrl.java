package com.revature.project3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project3.beans.Story;
import com.revature.project3.service.StoryService;

@RestController
public class AddStoryCtrl {

	@Autowired
	StoryService service;

	// Adds a new story to the dataBase.
	@PostMapping("/addStory")
	public Story addStory(@RequestBody Story story) {
		story = service.addStory(story);
		return story;
	}

	// Adds a new empty story to the dataBase.
	@GetMapping("/addStory/{storyId}")
	public Story addEmptyStory(@PathVariable String storyId) {
		Story story = new Story(Integer.parseInt(storyId));
		story.setStoryDesc("");
		story.setStoryName(storyId);
		story = service.addStory(story);
		return story;
	}
}
