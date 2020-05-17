//package com.org.service;
//
//import com.org.model.Users;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.org.model.Users;
//import com.org.dao.UserDao;
//
//@Service
//public class LoginServiceImpl implements LoginService {
//	
//	@Autowired
//	UserDao userDao;
//	
//	@Override
//	public String login(String email, String password) {
//		long id=userDao.getIdByEmail(email);
//		Optional<Users> findById =  userDao.findById(id);
//		if(findById.isPresent()) {
//			Users user = findById.get();
//			if(user.getUserPassword().equals(password)) {
//				if(user.getUserType().equals("True")){
//					return "Admin";
//					}
//				else { 
//					return "User";
//				}
//			}
//			return "Incorrect Password";
//		}
//		return "The User is Not Present" ;
//	}
//}
//
//	
//
