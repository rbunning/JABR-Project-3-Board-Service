package com.revature.project3.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project3.beans.Chart;
import com.revature.project3.beans.Story;
import com.revature.project3.dao.ChartRepository;
import com.revature.project3.dao.StoryRepository;

@Service(value = "AppChartService")
public class ChartService {
	@Autowired
	ChartRepository chartRepo;
	
	@Autowired 
	StoryRepository storyRepo;

	public Set<Story> getStorySet(int boardNum) {
		return (Set<Story>) storyRepo.findByboardId(boardNum);
	}

	public Chart getChart(int boardNum) {
		return chartRepo.findByboardId(boardNum);
	}
}
