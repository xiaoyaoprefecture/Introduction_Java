package com.xiaoyao.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaoyao.bean.User;
import com.xiaoyao.service.UserService;
import com.xiaoyao.utils.ToJsonUtils;

@Controller
public class UserController {
	List<User>list=new ArrayList();
	
	@Autowired
	private UserService us;
//	这个是查询所有
	@RequestMapping(value="selectAll",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectAll() {
		List<User>list=us.selectAll();
		for(User user :list) {
			System.out.println(user);
		}
		return ToJsonUtils.getJson("success",list);		
	}
	//	这个是添加用户
	@RequestMapping("addUser")
	@ResponseBody
	public String addUser(String userName,String password,String sex) {
		list.clear();
		boolean tag=us.addUser(userName,password,sex);
		if(tag) {//注册成功，返回到主页
			System.out.println("注册成功");
			list=us.selectUserByUserName(userName);
			return ToJsonUtils.getJson("success",list);		
		}else {//返回到注册页面
			System.out.println("注册失败");
			return ToJsonUtils.getJson("false",list);	
		}		
	}
	
	//登录
	@RequestMapping("login")
	@ResponseBody
	public String login(String userAccount,String password) {
		System.out.println(userAccount+"---"+password);
		list.clear();
		boolean tag=us.login(userAccount,password);
		if(tag) {//登录成功，返回到主页
			list=us.selectUserByUserAccount(userAccount);
			return ToJsonUtils.getJson("success",list);		
		}else {//返回到注册页面
			System.out.println("登录失败");
			return ToJsonUtils.getJson("false",list);
		}		
	}
	
}
