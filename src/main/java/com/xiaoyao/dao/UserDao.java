package com.xiaoyao.dao;

import java.util.List;

import com.xiaoyao.bean.User;

public interface UserDao {
	//����û�
	void addUser(User user);
	//�����û�����ѯ�û��Ƿ����
	List<User> selectUserByUserName(User user);
	//��ѯ����
	List<User>selectAll();
}
