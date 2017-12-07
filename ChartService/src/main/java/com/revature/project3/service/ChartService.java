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
	
	@HystrixCommand(fallbackMethod = "fallBackResponse")
	public void testFallback() {
		System.err.println("This is testing fallback");
	}
	
	public void fallBackResponse( ) {
		System.err.println("Fallback success!");
	}
	
	public Chart defaultChart(int boardNum) {
		Chart defaultChart = new Chart(100, "This is default board");
		return defaultChart;
	}
}
