package com.org.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.dao.UserDao;
import com.org.dao.UserLoginDao;
import com.org.model.UserLogin;
import com.org.model.Users;

@Service
public class UserLoginServiceImpl implements UserLoginService {

	@Autowired
	UserLoginDao userLoginDao;
	
	@Autowired
	UserDao userDao;
	
	@Override
	public Optional<Users> userLogin(UserLogin userLogin) {
		
		Iterable<Users> users = userDao.findAll(); 
        int id=-1;
		for(Users u: users) {
			 Users userObj = u;
	            if (userObj.getUserName().equals(userLogin.getUserName()) && userObj.getUserPassword().equals(userLogin.getPassword()))
	                id = userObj.getUserId();
        }
		
		return userDao.findById(id);
	}
	
	
}
