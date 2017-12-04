package com.revature.project3.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.revature.project3.beans.Board;
import com.revature.project3.beans.Chart;
import com.revature.project3.dao.ChartRepository;

@EnableBinding(Sink.class)
public class BoardMessageHandler {

	@Autowired
	ChartRepository chartRepository;

	@StreamListener(target = Sink.INPUT, condition = "headers['Action'] == 'add'")
	public void addBoard(Board board) {
		Chart chart = new Chart(board.getBoardId(),board.getBoardName());
		chartRepository.save(chart);
	}
}
