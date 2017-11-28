package com.revature.project3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project3.beans.Story;
import com.revature.project3.message.StoryMessageSource;
import com.revature.project3.service.StoryService;

@RestController
public class AddStoryCtrl {
	
	@Autowired
	StoryService service;
	
	@Autowired
	StoryMessageSource storyMessageSource;
	
	// Adds a new story to the dataBase.
	@PostMapping("/addStory")
	public Story addStory(Story story) {
		
		story = service.addStory(story);
		Message<Story> msg = MessageBuilder.withPayload(story).setHeader("Action", "add").build();
		storyMessageSource.storyMessage().send(msg);
		return story;
	}
	
	// Adds a new empty story to the dataBase.
	@GetMapping("/addStory/{storyId}")
	public Story addEmptyStory(@PathVariable String storyId) {
		
		Story story = new Story(Integer.parseInt(storyId));
		story = service.addStory(story);
		Message<Story> msg = MessageBuilder.withPayload(story).setHeader("Action", "add").build();
		storyMessageSource.storyMessage().send(msg);
		return story;
	}
}
