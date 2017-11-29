package com.revature.project3.dao;

import org.springframework.data.repository.CrudRepository;

import com.revature.project3.beans.Chart;

public interface ChartRepository extends CrudRepository<Chart, Integer> {
	Chart findByboardId (int boardId);
	
}
