package com.xiaoyao.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoyao.bean.User;
import com.xiaoyao.bean.User_Short;
import com.xiaoyao.dao.UserDao;

@Service
public class UserService {
	@Autowired
	private UserDao ud;
	
	//����һ����¼�ķ���
	public boolean login(String UserAccount,String password) {
		User_Short us=new User_Short(UserAccount,password);
		List<User> list =ud.selectUserByUserNameAndPassword(us);
		if(list.size()>0) {
			return true;
		}else {
			return false;
		}
	}
	
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
		List<User> list=selectUserByUserName(userName);
		return list.size()>0?true:false;
	}
	//�����û�����ѯ�û�
	public List<User>selectUserByUserName(String userName){
		return ud.selectUserByUserName(userName);
	}
	//�����˺Ų�ѯ�û�
	public List<User>selectUserByUserAccount(String userAccount){
		return ud.selectUserByUserAccount(userAccount);
	}
}
