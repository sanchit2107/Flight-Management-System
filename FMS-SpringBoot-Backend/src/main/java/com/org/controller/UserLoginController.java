package com.org.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.model.UserLogin;
import com.org.model.Users;
import com.org.service.UserLoginServiceImpl;

@RestController
@CrossOrigin("http://localhost:4200")
public class UserLoginController {
	
    @Autowired
    UserLoginServiceImpl userLoginService;

    @PostMapping("/login")
    public ResponseEntity<Optional<Users>> userLogin(@Valid @RequestBody UserLogin userLogin) {
        try {
            Optional<Users> user = userLoginService.userLogin(userLogin);
            return new ResponseEntity<Optional<Users>>(user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.IM_USED);
        }

    }
}