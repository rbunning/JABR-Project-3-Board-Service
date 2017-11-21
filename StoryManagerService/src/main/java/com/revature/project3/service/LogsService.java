package com.revature.project3.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project3.beans.Logs;
import com.revature.project3.dao.LogsRepository;

@Service(value = "AppLogsService")
public class LogsService {
	
	@Autowired
	LogsRepository logsRepo;
	
	public List<Logs> GetLogsByDate() {
		return logsRepo.findBylogsDatedLike(LocalDate.now().toString());
	}
	
	public List<Logs> GetAllLogs() {
		return (List<Logs>) logsRepo.findAll();
	}

}
