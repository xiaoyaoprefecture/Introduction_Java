package com.xiaoyao.dao;

import java.util.List;
import com.xiaoyao.bean.User;
import com.xiaoyao.bean.User_Short;

public interface UserDao {
	//添加用户
	void addUser(User user);
	//根据用户名查询用户是否存在
	List<User> selectUserByUserName(String userName);
	//根据账号查询用户是否存在
	List<User> selectUserByUserAccount(String userAccount);
	//查询所有
	List<User>selectAll();
	//根据账号密码查询是否存在当前用户
	List<User> selectUserByUserNameAndPassword(User_Short us);
	
}
