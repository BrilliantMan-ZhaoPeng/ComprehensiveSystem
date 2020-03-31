package com.zp.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zp.modules.account.entity.User;
import com.zp.repository.UserMapper;
@Service
public class UserService {
	@Autowired
    private UserMapper userMapper;
	//查询所有的用户，，，不分页
	public List<User> selAllUsers(){
		return userMapper.selAll();
	}
	
	//插入用户，
	public int insUser(User user){
		return userMapper.insUserByUser(user);
	}
	
	public User selUserByUserName(String userName) {
		return userMapper.selUserByUserName(userName);
	}
}
