package com.revature.project3.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project3.beans.Logs;

@RestController
public class GetLogsCtrl {

	@GetMapping("/storyLogs")
	public List<Logs> getAllLogs() {
		return null;
	}
	
	@GetMapping("/storyCurrentLogs")
	public List<Logs> getAllCurrentLogs() {
		return null;
	}
}
