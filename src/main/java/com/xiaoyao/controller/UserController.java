package com.xiaoyao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaoyao.bean.User;
import com.xiaoyao.service.UserService;

@Controller
public class UserController {
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
		return list.toString();		
	}
//	这个是添加用户
	@RequestMapping("addUser")
	@ResponseBody
	public String addUser(User user) {
		boolean tag=us.addUser(user);
		if(tag) {//注册成功，返回到主页
			
			return "";	
		}else {//返回到注册页面
			
			return "";	
		}		
	}
	
}
