package com.revature.project3.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.revature.project3.beans.BoardUserJoin;
import com.revature.project3.beans.ScrumUser;
import com.revature.project3.dao.BoardUserJoinRepository;
import com.revature.project3.dao.ScrumUserRepository;
import com.revature.project3.dto.BoardUserDto;

@Service(value = "AppUserService")
public class UserService implements UserDetailsService {

	@Autowired
	ScrumUserRepository scrumUserRepository;

	@Autowired
	BoardUserJoinRepository boardUserJoinRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<ScrumUser> usersOptional = scrumUserRepository.findOneByscrumUserUsername(username);
		usersOptional.orElseThrow(() -> new UsernameNotFoundException("Username not found!"));
		return usersOptional.get();
	}

	public void addUser(BoardUserDto boardUserDto) {
		ScrumUser scrumUser = scrumUserRepository.findOne(boardUserDto.getScrumUserId());
		Set<BoardUserJoin> boardUsers = scrumUser.getBoardUserJoins();
		BoardUserJoin newBoardUser = new BoardUserJoin(boardUserDto.getBoardId(), scrumUser);
		boardUsers.add(newBoardUser);
		scrumUser.setBoardUserJoins(boardUsers);
		boardUserJoinRepository.save(newBoardUser);
	}

	public List<ScrumUser> getUsers() {
		return (List<ScrumUser>) scrumUserRepository.findAll();
	}

	public List<ScrumUser> getAllUsersNotOnBoard(int boardNum) {
		List<ScrumUser> scrumUserListOnBoard = scrumUserRepository.findByboardUserJoins_boardId(boardNum);
		List<ScrumUser> scrumUserList = (List<ScrumUser>) scrumUserRepository.findAll();
		for (ScrumUser su : scrumUserListOnBoard) {
			scrumUserList.remove(su);
		}
		return scrumUserList;
	}

	public List<ScrumUser> getAllUsersOnBoard(int boardNum) {
		return scrumUserRepository.findByboardUserJoins_boardId(boardNum);
	}

	public Set<BoardUserJoin> getBoardsForUser(int userNum) {
		ScrumUser scrumUser = scrumUserRepository.findOne(userNum);
		return scrumUser.getBoardUserJoins();
	}

	public ScrumUser loginUser(ScrumUser userLogin) {
		ScrumUser validUser = new ScrumUser();
		validUser.setScrumUserId(0);
		List<ScrumUser> userList = (List<ScrumUser>) scrumUserRepository
				.findByscrumUserUsername(userLogin.getScrumUserUsername());
		if (userList.size() == 1) {
			validUser = userList.get(0);
			if (!validUser.getScrumUserPassword().equals(userLogin.getScrumUserPassword())) {
				validUser.setScrumUserId(0);
			}
		}
		return validUser;
	}
}
