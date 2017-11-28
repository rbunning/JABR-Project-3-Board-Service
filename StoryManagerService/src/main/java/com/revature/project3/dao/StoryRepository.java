package com.revature.project3.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.revature.project3.beans.Story;

public interface StoryRepository extends CrudRepository<Story, Integer>{
	
	List<Story> findByBoardId(int board);
	
	List<Story> findByBoardIdAndLaneTypeId(int board, int laneType);

}
