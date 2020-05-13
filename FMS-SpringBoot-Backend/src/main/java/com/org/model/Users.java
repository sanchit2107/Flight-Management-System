package com.org.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Users {
	 @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;//auto generated, not to be taken as input by user.

    @Column(name = "userType", nullable = false)
    @NotNull(message = "User type can't be blank, choose either 'Customer' or 'Admin'.")
    private String userType;

    @Column(name = "userName", nullable = false, unique = true)
    @NotNull(message = "User name can't be empty")
    private String userName;

    @Column(name = "userPassword", nullable = false)
    @NotNull(message = "User password can't be empty")
    private String userPassword;

    @Column(name = "userPhone", nullable = false, unique = true)
    @NotNull(message = "User phone number can't be empty")
    private String userPhone;

    @Column(name = "userEmail", nullable = false, unique = true)
    @NotNull(message = "User userEmail can't be empty")
    private String userEmail;


	/**
	 * Parameterized Constructors of Users
	 */
	public Users(String userName, String userPassword, String userPhone, String userEmail, String userType,
			int userId) {
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
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

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
}