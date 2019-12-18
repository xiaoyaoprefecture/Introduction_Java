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
	public String addUser(String userName,String password,String sex) {
		boolean tag=us.addUser(userName,password,sex);
		if(tag) {//注册成功，返回到主页
			System.out.println("注册成功");
			return "sucess";	
		}else {//返回到注册页面
			System.out.println("注册失败");
			return "false";	
		}		
	}
	//登录
//	@RequestMapping("login")
//	@ResponseBody
//	public String login(String UserAccount,String password) {
//		boolean tag=us.login(UserAccount,password);
//		if(tag) {//登录成功，返回到主页
//			System.out.println("登录成功");
//			return "http://127.0.0.1:8020/WebIntroduction/html/homePage.html?__hbt=1576639420076";	
//		}else {//返回到注册页面
//			System.out.println("登录失败");
//			return "false";	
//		}		
//	}
	
}
