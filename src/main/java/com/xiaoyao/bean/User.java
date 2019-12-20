package com.xiaoyao.bean;

import java.io.Serializable;
/**
 * 
 * @author ly
 * 封装的用户实体类
 */
public class User implements Serializable{
	private Integer userID;
	private String userName;
	private String userPassword;
	private String userAccount;
	private String userSex;
	
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
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
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public User() {
		super();
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public User(Integer userID, String userName, String userPassword, String userAccount, String userSex) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userAccount = userAccount;
		this.userSex = userSex;
	}
//	@Override
//	public String toString() {
//		return "{\"userID\":\""+userID+"\",\"userName\":\""+userName+"\",\"userPassword\":\""+userPassword+"\",\"userAccount\":\""+
//				userAccount+"\",\"userSex\":\""+userSex+"\"}";			
//	}	
	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", userPassword=" + userPassword + ", userAccount="
				+ userAccount + ", userSex=" + userSex + "]";
	}
	
}
