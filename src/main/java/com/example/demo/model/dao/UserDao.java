package com.example.demo.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import com.example.demo.model.bean.User;
import com.example.demo.model.bean.Vote;

@Mapper
public interface UserDao {

	public User find(@Param("name")String name, @Param("password")String password);
	public User find1(@Param("name")String name, @Param("password")String password);
	void update(User user);
	int add(User user);
	// 注： CRTL+Shift+O，快捷导入所有import
	User findOne(User user);
	List<User> findAllUserName();
	int findId(String name);
	List<Vote> selectVoteById(int id);
	void modifyUser(User user);
	void deleteUser(User user);
	User selectUserById(int id);
}