package com.xiaoyao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoyao.bean.User;
import com.xiaoyao.dao.UserDao;

@Service
public class UserService {
	@Autowired
	private UserDao ud;
	
	public List<User>selectAll(){
		return ud.selectAll();
	}
	
	//定义一个添加用户的方法
	public boolean addUser(User user) {
		if (isHave(user)) {
			return false;
		}else {
			ud.addUser(user);
			return true;
		}
	}
	//添加一个判断用户是否存在的方法
	public boolean isHave(User user) {
		List<User> list=ud.selectUserByUserName(user);
		return list.size()>0?true:false;
	}
}
