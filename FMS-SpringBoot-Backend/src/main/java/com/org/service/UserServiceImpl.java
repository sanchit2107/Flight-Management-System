package com.org.service;

import java.math.BigInteger;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.org.dao.UserDao;
import com.org.exceptions.RecordAlreadyPresentException;
import com.org.exceptions.RecordNotFoundException;
import com.org.model.Users;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public ResponseEntity<?> createUser(Users newUser) {
				userDao.save(newUser);
				return new ResponseEntity<Users>(newUser, HttpStatus.OK);
	}
		

	@Override
	public void updateUser(Users updateUser) {
		
		Optional<Users> findUserById = userDao.findById(updateUser.getUserId());
		if (findUserById.isPresent()) {
			userDao.save(updateUser);
		} else
			throw new RecordNotFoundException("User with Id: " + updateUser.getUserId() + " not exists!!");
	}

	@Override
	public void deleteUser(Integer UserId) {
		Optional<Users> findBookingById = userDao.findById(UserId);
		if (findBookingById.isPresent()) {
			userDao.deleteById(UserId);
			
		} else
			throw new RecordNotFoundException("User not found for the entered UserID");
	}

	@Override
	public Iterable<Users> displayAllUser() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public Users findUserById(Integer userId) {
		
		Optional<Users> findById = userDao.findById(userId);
		
			if (findById.isPresent()) {
				return findById.get();
				
			} else
				throw new RecordNotFoundException("No record found with ID " + userId);
		} 
			
	}
	

