package com.rensframework.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rensframework.entity.User;
import com.rensframework.user.dao.UserDao;

@Service
public class UserService {

	
	@Autowired
	private UserDao userDao;
	
	public List<User> findAll(){
		return userDao.findAll();
	}
	public List<User> findByName(String name){
		return userDao.findByName(name);
	}
	public User creative(User user){
		return userDao.insert(user);
	}
	
	public void remove(Long userId){
		userDao.delete(userId);
	}
	public User findByAccount(String account) {
		return userDao.findByAccount(account);
	}
	
}
