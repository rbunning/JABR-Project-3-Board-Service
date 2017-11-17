package com.revature.project3.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.revature.project3.bean.ScrumUser;

public interface ScrumUserRepository extends CrudRepository<ScrumUser, Integer> {
	List<ScrumUser> findByboardUserJoins_boardUserJoinIdDto_boardId(int boardId);
	List<ScrumUser> findByboardUserJoins_boardUserJoinIdDto_boardIdNot(int boardId);
}
