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
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.revature.project3.beans.Chart;
import com.revature.project3.beans.Story;
import com.revature.project3.dto.ChartDataDto;
import com.revature.project3.dto.ChartDatasetDto;
import com.revature.project3.dto.ChartDto;
import com.revature.project3.service.ChartService;

@EnableEurekaClient
@RestController
@EnableCircuitBreaker
public class GetChartCtrl {

	@Autowired
	private Environment environment;
	
	@Autowired
	ChartService chartService;

	@LoadBalanced
	@Bean
	public RestTemplate buildRestTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.build();
	}

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * Retrieves the data to populate the chart
	 * @param boardId
	 * @param request
	 * @return
	 */
	@HystrixCommand(fallbackMethod = "failedChartResponse")	//Circuit breaker with fallback method for default data
	@GetMapping(path = "/getChart/{boardId}", produces = "application/json")
	public ResponseEntity<ChartDto> getChartData(@PathVariable String boardId, HttpServletRequest request) {
		String storyUrl = environment.getProperty("rest-template-urls.story-service");
		String url = "http://"+ storyUrl +"/allboardStories/" + boardId;
		String token = request.getHeader("Authorization"); // Gets the OAuth2 token for the request header.
		int boardNum = Integer.parseInt(boardId); // Parses the board from the URL.
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON); // Sets the media type to JSON.
		headers.set("Authorization", token); // Adds the OAuth2 token to the new request header.
		HttpEntity<String> entity = new HttpEntity<String>("parameters",headers);
		ResponseEntity<Story[]> resStoryArray = restTemplate.exchange(url, HttpMethod.GET, entity, Story[].class); // Send the new request.
		
		List<Story> stories = Arrays.asList(resStoryArray.getBody());
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
		return new ResponseEntity<ChartDto>(burndownChart, HttpStatus.OK);
	}
	
	/**
	 * Sends a response with default data for the chart when StoryManagerService is down
	 * @param message
	 * @param request
	 * @return
	 */
	public ResponseEntity<ChartDto> failedChartResponse(String message, HttpServletRequest request) {
		List<String> defaultDataLabels = new ArrayList<>();
		List<Integer> defaultDataValues = new ArrayList<>();
		defaultDataLabels.add("Default Label 1");
		defaultDataValues.add(0);
		String[] defaultLabelsArray = defaultDataLabels.toArray(new String[defaultDataLabels.size()]);
		int[] defaultDataValuesArray = new int[defaultDataValues.size()];
		ChartDatasetDto defaultCdsd = new ChartDatasetDto(defaultDataValuesArray);
		List<ChartDatasetDto> defaultCdsdList = new ArrayList<>();
		defaultCdsdList.add(defaultCdsd);
		ChartDataDto defaultCdd = new ChartDataDto(defaultLabelsArray, defaultCdsdList);
		ChartDto defaultChart = new ChartDto(defaultCdd);
		return new ResponseEntity<ChartDto>(defaultChart, HttpStatus.OK);
	}

}
