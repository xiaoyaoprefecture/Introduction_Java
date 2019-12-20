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
//	����ǲ�ѯ����
	@RequestMapping(value="selectAll",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectAll() {
		List<User>list=us.selectAll();
		for(User user :list) {
			System.out.println(user);
		}
		return ToJsonUtils.getJson("success",list);		
	}
	//	���������û�
	@RequestMapping("addUser")
	@ResponseBody
	public String addUser(String userName,String password,String sex) {
		list.clear();
		boolean tag=us.addUser(userName,password,sex);
		if(tag) {//ע��ɹ������ص���ҳ
			System.out.println("ע��ɹ�");
			list=us.selectUserByUserName(userName);
			return ToJsonUtils.getJson("success",list);		
		}else {//���ص�ע��ҳ��
			System.out.println("ע��ʧ��");
			return ToJsonUtils.getJson("false",list);	
		}		
	}
	
	//��¼
	@RequestMapping("login")
	@ResponseBody
	public String login(String userAccount,String password) {
		System.out.println(userAccount+"---"+password);
		list.clear();
		boolean tag=us.login(userAccount,password);
		if(tag) {//��¼�ɹ������ص���ҳ
			list=us.selectUserByUserAccount(userAccount);
			return ToJsonUtils.getJson("success",list);		
		}else {//���ص�ע��ҳ��
			System.out.println("��¼ʧ��");
			return ToJsonUtils.getJson("false",list);
		}		
	}
	
}
