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
//	����ǲ�ѯ����
	@RequestMapping(value="selectAll",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectAll() {
		List<User>list=us.selectAll();
		for(User user :list) {
			System.out.println(user);
		}
		return list.toString();		
	}
	//	���������û�
	@RequestMapping("addUser")
	@ResponseBody
	public String addUser(String userName,String password,String sex) {
		boolean tag=us.addUser(userName,password,sex);
		if(tag) {//ע��ɹ������ص���ҳ
			System.out.println("ע��ɹ�");
			return "sucess";	
		}else {//���ص�ע��ҳ��
			System.out.println("ע��ʧ��");
			return "false";	
		}		
	}
	//��¼
//	@RequestMapping("login")
//	@ResponseBody
//	public String login(String UserAccount,String password) {
//		boolean tag=us.login(UserAccount,password);
//		if(tag) {//��¼�ɹ������ص���ҳ
//			System.out.println("��¼�ɹ�");
//			return "http://127.0.0.1:8020/WebIntroduction/html/homePage.html?__hbt=1576639420076";	
//		}else {//���ص�ע��ҳ��
//			System.out.println("��¼ʧ��");
//			return "false";	
//		}		
//	}
	
}
