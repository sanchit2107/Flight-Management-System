package com.org.service;

import java.math.BigInteger;

import org.springframework.http.ResponseEntity;

import com.org.model.Users;

public interface UserService {

	public ResponseEntity<?> createUser(Users newUser);

	public void updateUser(Users newUser);

	public void deleteUser(Integer UserId);

	public Iterable<Users> displayAllUser();

	public Users findUserById(Integer userId);
}