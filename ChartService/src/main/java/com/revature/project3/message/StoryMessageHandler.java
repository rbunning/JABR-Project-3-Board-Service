package com.revature.project3.message;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.revature.project3.beans.Story;
import com.revature.project3.dao.StoryRepository;

@EnableBinding(Sink.class)
public class StoryMessageHandler {
	@Autowired
	DataSource dataSource;

	@Autowired
	StoryRepository storyRepo;

	@StreamListener(target = Sink.INPUT, condition = "headers['Action'] == 'add'")
	public void addStory(Story story) {
		storyRepo.save(story);
	}

	@StreamListener(target = Sink.INPUT, condition = "headers['Action'] == 'update'")
	public void updateStory(Story story) {
		storyRepo.save(story);
	}
}
