package com.revature.project3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project3.beans.Chart;
import com.revature.project3.dao.ChartRepository;

@Service
public class MockitoChartTestService {

	@Autowired
	private ChartRepository chartRepo;
	
	public Chart getChart(int chartId) {
		return chartRepo.findOne(chartId);
	}
	
	public Chart getChartByBoardId(int boardNum) {
		return chartRepo.findByboardId(boardNum);
	}
	
	//This will be used for mockito/unit test
		public void setChartRepository (ChartRepository chartRepo) {
			this.chartRepo = chartRepo;
		}
	
	
}
