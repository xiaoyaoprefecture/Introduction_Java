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
	
	//����һ����¼�ķ���
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
	
	//����һ������û��ķ���
	public boolean addUser(String userName,String password,String sex) {
		if (isHave(userName)) {
			return false;
		}else {//û�е�ǰ�û�������ǳ�
			//����һ��������������˺�
			String userAccount=randomAccount();
			System.out.println("������ɵ��˺���:"+userAccount);
			
			ud.addUser(new User(0,userName,password,userAccount,sex));
			return true;
		}
	}
	//����һ��������������˺�
	private String randomAccount() {
		// TODO Auto-generated method stub
		String userAccount="";
		for(int i=0;i<6;i++) {
			userAccount+=new Random().nextInt(10);
		}
		return userAccount;
	}

	//���һ���ж��û��Ƿ���ڵķ���
	public boolean isHave(String userName) {
		List<User> list=ud.selectUserByUserName(userName);
		return list.size()>0?true:false;
	}
}
