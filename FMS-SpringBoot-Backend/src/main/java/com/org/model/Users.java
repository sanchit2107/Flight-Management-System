package com.org.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)

	private Integer userId;
	private String userType;
	
	private String userName;
	private String userPassword;
	private long userPhone;
	private String userEmail;

	/**
	 * Parameterized Constructors of Users
	 */
	public Users(String userName, String userPassword, long userPhone, String userEmail, String userType) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userType = userType;
	}

	/**
	 * Unparameterized Constructor of User
	 */
	public Users() {
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public long getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(long userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
//	@Override
//	public String toString() {
//		return "Users{userId='\" + userId + '\\'' + \"," + "userName='" + userName + '\'' + ","
//				+ " userPassword='" + userPassword + '\'' + ", userPhone='" + userPhone + '\'' + ","
//				+ "	userEmail='" + userEmail + '\'' +'}';
//	}
}