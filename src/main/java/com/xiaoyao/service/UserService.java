package com.xiaoyao.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoyao.bean.User;
import com.xiaoyao.dao.UserDao;

@Service
public class UserService {
	@Autowired
	private UserDao ud;
	
	//定义一个登录的方法
//	public boolean login(String UserAccount,String password) {
//		List<User> list =ud.selectUserByUserName(UserAccount, password);
//		if(list.size()>0) {
//			return true;
//		}else {
//			return false;
//		}
//	}
//	
	public List<User>selectAll(){
		return ud.selectAll();
	}
	
	//定义一个添加用户的方法
	public boolean addUser(String userName,String password,String sex) {
		if (isHave(userName)) {
			return false;
		}else {//没有当前用户输入的昵称
			//定义一个函数随机生成账号
			String userAccount=randomAccount();
			System.out.println("随机生成的账号是:"+userAccount);
			
			ud.addUser(new User(0,userName,password,userAccount,sex));
			return true;
		}
	}
	//定义一个函数随机生成账号
	private String randomAccount() {
		// TODO Auto-generated method stub
		String userAccount="";
		for(int i=0;i<6;i++) {
			userAccount+=new Random().nextInt(10);
		}
		return userAccount;
	}

	//添加一个判断用户是否存在的方法
	public boolean isHave(String userName) {
		List<User> list=ud.selectUserByUserName(userName);
		return list.size()>0?true:false;
	}
}
