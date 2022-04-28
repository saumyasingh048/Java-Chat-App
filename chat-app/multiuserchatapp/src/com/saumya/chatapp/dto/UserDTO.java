package com.saumya.chatapp.dto;

import static com.saumya.chatapp.utils.Encryption.passwordEncrypt;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;

public class UserDTO {
	private String userID;
	private String password;
	private String name;
	private String emailID;
	private String city;
	private BigInteger phoneNo;
	public UserDTO(String userID, String password) throws NoSuchAlgorithmException {
		this.userID = userID;
		this.password = passwordEncrypt(password);
	}
	public UserDTO(String userID, String password, String name, String emailID, String city, BigInteger phoneNo) throws NoSuchAlgorithmException {
		this.userID = userID;
		this.password = passwordEncrypt(password);
		this.name = name;
		this.emailID = emailID;
		this.city = city;
		this.phoneNo = phoneNo;
	}
	public String getName() {
		return name;
	}
//	public void setName(String name) {
//		this.name = name;
//	}
	public String getEmailID() {
		return emailID;
	}
//	public void setEmailID(String emailID) {
//		this.emailID = emailID;
//	}
	public String getCity() {
		return city;
	}
//	public void setCity(String city) {
//		this.city = city;
//	}
	public BigInteger getPhoneNo() {
		return phoneNo;
	}
//	public void setPhoneNo(Long phoneNo) {
//		this.phoneNo = phoneNo;
//	}
	public String getUserID() {
		return userID;
	}
	// Never Called Function, hence commented.
//	public void setUserID(String userID) {
//		this.userID = userID;
//	}
	public String getPassword() {
		return password;
	}
	// Never Called Function, hence commented.
//	public void setPassword(String password) {
//		this.password = password;
//	}
}
