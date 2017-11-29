package com.revature.project3.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.revature.project3.bean.ScrumUser;
import com.revature.project3.dao.ScrumUserRepository;
import com.revature.project3.dao.UserRepository;

@Service("userDetailsService")
public class UserService implements UserDetailsService {

	@Autowired
	private ScrumUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<ScrumUser> usersOptional = userRepository.findOneByscrumUserUsername(username);
		usersOptional.orElseThrow(() -> new UsernameNotFoundException("Username not found!"));
		return usersOptional.get();
	}
}
