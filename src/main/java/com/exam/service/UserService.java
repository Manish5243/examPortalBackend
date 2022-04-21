package com.exam.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.exam.entity.User;
import com.exam.entity.UserRole;

@Service
public interface UserService {
	
	//creating user
	public User createUser(User user, Set<UserRole> userRoles);
	
	//get user by user name 
	public User getUser(String userName);
	
	//delete user by id
	public void deleteUser(Long userId);

}
