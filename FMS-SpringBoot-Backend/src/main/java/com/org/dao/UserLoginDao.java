package com.org.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.model.UserLogin;

@Repository
public interface UserLoginDao extends JpaRepository<UserLogin, String> {
	
}
