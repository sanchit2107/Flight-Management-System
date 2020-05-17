//package com.org.controller;
//
//import org.apache.catalina.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.org.service.LoginService;
//
//@RestController
//@CrossOrigin("*")
//public class LoginController {
//	
//	@Autowired
//	LoginService loginService;
//	@PostMapping("/login")
//	public ResponseEntity<?> login(@Request User user){
//		String s=loginService.login(user.getUserEmail(), user.getuserPassword());
//		return new ResponseEntity<String>(s,HttpStatus.OK)
//	}
//
//}
