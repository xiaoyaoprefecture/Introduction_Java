package com.xiaoyao.dao;

import java.util.List;

import com.xiaoyao.bean.User;

public interface UserDao {
	//添加用户
	void addUser(User user);
	//根据用户名查询用户是否存在
	List<User> selectUserByUserName(User user);
	//查询所有
	List<User>selectAll();
}
