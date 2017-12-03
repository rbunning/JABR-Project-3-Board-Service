package com.revature.project3.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.revature.project3.beans.ScrumUser;

public interface ScrumUserRepository extends CrudRepository<ScrumUser, Integer> {
	List<ScrumUser> findByboardUserJoins_boardId(int boardId);
	List<ScrumUser> findByscrumUserUsername(String userName);
	Optional<ScrumUser> findOneByscrumUserUsername(String username);
}
