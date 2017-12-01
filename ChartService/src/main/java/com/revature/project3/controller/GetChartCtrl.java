package com.revature.project3.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revature.project3.beans.Chart;
import com.revature.project3.beans.Story;
import com.revature.project3.dto.ChartDataDto;
import com.revature.project3.dto.ChartDatasetDto;
import com.revature.project3.dto.ChartDto;
import com.revature.project3.service.ChartService;

@EnableEurekaClient
@RestController
public class GetChartCtrl {

	@Autowired
	ChartService chartService;

	@LoadBalanced
	@Bean
	public RestTemplate buildRestTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.build();
	}

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping(path = "/getChart/{boardId}", produces = "application/json")
	public ResponseEntity<ChartDto> getChartData(@PathVariable String boardId, HttpServletRequest request) {
		int boardNum = Integer.parseInt(boardId);

		String url = "http://story-manager-service/allboardStories/" + boardId;
		Story[] storyArray = restTemplate.getForObject(url, Story[].class);
		List<Story> stories = Arrays.asList(storyArray);
		Map<LocalDate, Integer> storyData = new TreeMap<LocalDate, Integer>();
		int totalPoints = 0;
		for (Story story : stories) {
			if (story.getLaneTypeId() != 1) {
				totalPoints += story.getStoryPoints();
			}
			if (story.getLaneTypeId() == 6) {
				LocalDate doneDate = story.getLastMoveDate().toLocalDate();
				storyData.put(doneDate, story.getStoryPoints());
			}
		}

		List<String> dataLabels = new ArrayList<>();
		List<Integer> dataValues = new ArrayList<>();
		Chart chart = chartService.getChart(boardNum);
		LocalDate startDate = chart.getStartDate().toLocalDate();
		dataLabels.add(startDate.toString());
		dataValues.add(totalPoints);
		LocalDate prevDate = startDate;
		for (Map.Entry<LocalDate, Integer> entry : storyData.entrySet()) {
			LocalDate currentDate = entry.getKey();
			Integer points = entry.getValue();
			if (prevDate.equals(startDate) || prevDate.equals(currentDate)) {
				prevDate = currentDate;
				totalPoints -= points;
			} else {
				dataLabels.add(prevDate.toString());
				dataValues.add(totalPoints);
				prevDate = currentDate;
				totalPoints -= points;
			}
		}
		dataLabels.add(prevDate.toString());
		dataValues.add(totalPoints);

		String[] dataLabelsArray = dataLabels.toArray(new String[dataLabels.size()]);
		int[] dataValuesArray = new int[dataValues.size()];
		for (int i = 0; i < dataValuesArray.length; i++) {
			dataValuesArray[i] = dataValues.get(i).intValue();
		}
		ChartDatasetDto cdsd = new ChartDatasetDto(dataValuesArray);
		List<ChartDatasetDto> cdsdList = new ArrayList<>();
		cdsdList.add(cdsd);
		ChartDataDto cdd = new ChartDataDto(dataLabelsArray, cdsdList);
		ChartDto burndownChart = new ChartDto(cdd);
		System.err.println("burndownChart = " + burndownChart);
		return new ResponseEntity<ChartDto>(burndownChart, HttpStatus.OK);
	}

}
