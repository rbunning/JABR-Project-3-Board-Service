package com.revature.project3.dao;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.revature.project3.bean.Story;

public interface StoryRepository extends CrudRepository<Story, Integer>{
	Set <Story> findByboardId (int boardId);
}
