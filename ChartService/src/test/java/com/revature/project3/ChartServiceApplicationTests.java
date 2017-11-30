package com.revature.project3;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.project3.beans.Chart;
import com.revature.project3.dao.ChartRepository;
import com.revature.project3.service.LogsService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChartServiceApplicationTests {

	@Autowired
	ChartRepository chartRepo;
	
	@Autowired
	LogsService logsService;
	
	Chart testChart = new Chart(10, 2, null, null);
	
	@Test
	public void testChartById() {
		assertNotNull(chartRepo.findOne(testChart.getChartId()));
	}
	
	@Test
	public void testChartByBoardId() {
		assertNotNull(chartRepo.findByboardId(testChart.getBoardId()));
	}
	
	@Test
	public void testAllLogs() {
		assertNotNull(logsService.getAllLogs());
	}
	
	@Test
	public void contextLoads() {
	}

}