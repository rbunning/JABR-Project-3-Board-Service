package com.revature.project3.controller;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project3.beans.Story;
import com.revature.project3.dao.StoryRepository;

@RestController
public class DeleteStoryCtrl {
	@Autowired
	DataSource dataSource;

	@Autowired
	StoryRepository storyRepo;

	@PostMapping(path = "/deleteStory", consumes = "application/json")
	public ResponseEntity<Void> deleteStory(@RequestBody Story story, HttpServletRequest request) {
		storyRepo.delete(story);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
