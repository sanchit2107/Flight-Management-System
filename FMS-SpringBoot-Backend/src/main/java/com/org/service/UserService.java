package com.org.service;

import java.math.BigInteger;

import org.springframework.http.ResponseEntity;

import com.org.model.User;

public interface UserService {

	public ResponseEntity<?> createUser(User newUser);

	public User updateUser(User newUser);

	public String deleteUser(Long UserId);

	public Iterable<User> displayAllUser();

	public ResponseEntity<?> findUserById(Long userId);
}