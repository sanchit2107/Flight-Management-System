package com.org.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.org.model.UserLogin;
import com.org.model.Users;

public interface UserLoginService {

	public abstract Optional<Users> userLogin(UserLogin userLogin);

}
