package com.revature.project3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project3.beans.Chart;
import com.revature.project3.dao.ChartRepository;

@Service(value = "AppChartService")
public class ChartService {
	@Autowired
	ChartRepository chartRepo;
	
	public Chart getChart(int boardNum) {
		return chartRepo.findByboardId(boardNum);
	}
}
