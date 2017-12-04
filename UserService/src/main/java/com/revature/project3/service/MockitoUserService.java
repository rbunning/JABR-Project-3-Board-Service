package com.revature.project3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project3.beans.ScrumUser;
import com.revature.project3.dao.ScrumUserRepository;

@Service
public class MockitoUserService {
	@Autowired
	private ScrumUserRepository userRepo;
	
	public List<ScrumUser> findByboardUserJoins_boardId(int id) {
		return userRepo.findByboardUserJoins_boardId(id);
	}
	
	public List<ScrumUser> findUserByUsername(String username) {
		return userRepo.findByscrumUserUsername(username);
	}
	
	public void setUserRepo(ScrumUserRepository userRepo) {
		this.userRepo = userRepo;
	}
}
