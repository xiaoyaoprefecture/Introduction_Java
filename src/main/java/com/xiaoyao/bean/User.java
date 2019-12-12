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
	private Integer userAccount;
	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", userPassword=" + userPassword + ", userAccount="
				+ userAccount + "]";
	}
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
	public Integer getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(Integer userAccount) {
		this.userAccount = userAccount;
	}
	public User() {
		super();
	}
	public User(Integer userID, String userName, String userPassword, Integer userAccount) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userAccount = userAccount;
	}
}
