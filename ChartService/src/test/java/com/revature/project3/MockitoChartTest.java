package com.revature.project3;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.project3.beans.Chart;
import com.revature.project3.dao.ChartRepository;
import com.revature.project3.service.MockitoChartTestService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ChartServiceApplication.class)
public class MockitoChartTest {

	@Autowired
	private MockitoChartTestService mockChartService;
	
	@Autowired
	private ChartRepository mockChartRepo;
	
	@Before
	public void initialize() {
		mockChartService = new MockitoChartTestService();
		mockChartRepo = mock(ChartRepository.class);
		mockChartService.setChartRepository(mockChartRepo);
	}
	
	@Test
	public void testChartById() {
		Chart testChart = new Chart(10, 2, null, null);
		when(mockChartRepo.findOne(testChart.getChartId())).thenReturn(testChart);
		Chart returnedChart = mockChartService.getChart(testChart.getChartId());
		assertEquals(testChart, returnedChart);
	}
	
	@Test
	public void testChartByBoardId() {
		Chart testChart = new Chart(2, null);
		when(mockChartRepo.findOne(testChart.getBoardId())).thenReturn(testChart);
		Chart returnedChart = mockChartService.getChart(testChart.getBoardId());
		assertEquals(testChart, returnedChart);
	}
}
