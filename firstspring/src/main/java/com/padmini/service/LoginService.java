package com.padmini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.padmini.dao.UserDao;
import com.padmini.model.UserInfo;

@Service
public class LoginService {

	@Autowired
	private UserDao userDao;
	
	public List allUsers(UserInfo u)
	{
		System.out.println("In Service ");
		return userDao.getAllUsers(u);
		
	}
	
	public Boolean login(UserInfo u)
	{
		System.out.println("In Service ");
		return userDao.getUser(u);
		
	}
	
	public String signUp(UserInfo u)
	{
		System.out.println("In Service ");
		return userDao.signUp(u);
		
	}
	
}
