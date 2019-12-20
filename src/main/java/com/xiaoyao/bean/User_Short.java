package com.xiaoyao.bean;

import java.io.Serializable;
/**
 * 只要账号密码，用于登录验证账号密码
 * @author ly
 *
 */
public class User_Short implements Serializable{
	private String userAccount;
	private String userPassword;
	public User_Short(String userAccount, String userPassword) {
		super();
		this.userAccount = userAccount;
		this.userPassword = userPassword;
	}
	public User_Short() {
		super();
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
}
