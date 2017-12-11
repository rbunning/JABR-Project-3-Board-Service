package com.revature.project3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.revature.project3.beans.Chart;
import com.revature.project3.dao.ChartRepository;

@Service(value = "AppChartService")
public class ChartService {
	@Autowired
	ChartRepository chartRepo;
	
	private int tempBoardNum;
	
	@HystrixCommand(fallbackMethod = "defaultChart")
	public Chart getChart(int boardNum) {
		return chartRepo.findByboardId(boardNum);
	}
	
	public Chart defaultChart(int boardNum) {
		Chart defaultChart = new Chart(100, "Default Board");
		return defaultChart;
	}
}
