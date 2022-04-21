package com.exam.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;
import com.exam.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	//creating user
	@Override
	public User createUser(User user, Set<UserRole> userRoles) {
		
		User local = this.userRepository.findByUserName(user.getUserName());
		if(local != null) {
			System.out.println("user is already their");
			throw new RuntimeException("User already present !!");
		}
		else {
			//create user
			for(UserRole ur:userRoles) {
				roleRepository.save(ur.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			local = this.userRepository.save(user);
		}

		return local;
	}


	//get user by user name
	@Override
	public User getUser(String userName) {
		return this.userRepository.findByUserName(userName);
	}


	//delete user
	@Override
	public void deleteUser(Long userId) {
		
		this.userRepository.deleteById(userId);
	}

}
