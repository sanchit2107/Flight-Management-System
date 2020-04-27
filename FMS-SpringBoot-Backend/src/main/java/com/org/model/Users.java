package com.org.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Users {
	private String userType;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@OneToMany(mappedBy = "user")
	private BigInteger userId;
	@NotEmpty(message = "Name is mandatory")
	private String userName;
	@NotEmpty(message = "Password is mandatory")
	private String userPassword;
	@NotNull(message = "Phone number is mandatory")
	private BigInteger userPhone;
	@NotEmpty(message = "Email is mandatory")
	@Email(message = "Email should be in proper format")
	private String userEmail;
	
	public Users(BigInteger userId, String userName, String userPassword, BigInteger userPhone, String userEmail, String userType)
	/**
	 * Parameterized Constructors of Users
	 */
	{
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userType = userType;
	}
	public Users()
	/**
	 * Unparameterized Constructor of User
	 */
	{
	}



	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public BigInteger getUserId() {
		return userId;
	}
	public void setUserId(BigInteger userId) {
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
	public BigInteger getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(BigInteger userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
	
}
