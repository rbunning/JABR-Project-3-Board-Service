package com.revature.project3.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project3.beans.Story;

@RestController
public class GetStoryCtrl {
	
	@GetMapping("/allStories")
	public List<Story> getAllStories() {
		List<Story> stories = new ArrayList<>();
		stories.add(new Story());
		stories.add(new Story());
		stories.add(new Story());
		return stories;
	}
	
	@GetMapping("/story/{id}")
	public Story getStory(@PathVariable String id) {
		Story story = new Story(Integer.parseInt(id), 0, 0, "", 0, "", Date.valueOf(LocalDate.now()));
		return story;
	}
}
