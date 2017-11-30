package com.revature.project3.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.revature.project3.beans.BoardComment;

public interface BoardCommentRepository extends CrudRepository<BoardComment, Integer> {
	
	List<BoardComment> findByboardId(int boardId);
}
