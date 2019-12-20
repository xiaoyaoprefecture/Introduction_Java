package com.xiaoyao.dao;

import java.util.List;
import com.xiaoyao.bean.User;
import com.xiaoyao.bean.User_Short;

public interface UserDao {
	//����û�
	void addUser(User user);
	//�����û�����ѯ�û��Ƿ����
	List<User> selectUserByUserName(String userName);
	//�����˺Ų�ѯ�û��Ƿ����
	List<User> selectUserByUserAccount(String userAccount);
	//��ѯ����
	List<User>selectAll();
	//�����˺������ѯ�Ƿ���ڵ�ǰ�û�
	List<User> selectUserByUserNameAndPassword(User_Short us);
	
}
