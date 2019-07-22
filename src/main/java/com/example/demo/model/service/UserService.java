package com.example.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.bean.User;
import com.example.demo.model.bean.Vote;
import com.example.demo.model.dao.UserDao;
@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public User add(User user) {
        userDao.add(user);
        return findById(user.getId());
    }
	public User findById(int id) {
        User user = new User();
        user.setId(id);
        return userDao.findOne(user);
    }
	public void updateByName(User user) {
		userDao.update(user);
	}

    public User findByName(String name) {
        User param = new User();
        param.setName(name);
        return userDao.findOne(param);
    }
  //查找所有用户名
    public List<User> findAllUserName() {
        return userDao.findAllUserName();
    }
//    public int findId(String name) {
//    	int id1 = userDao.findId(name);
//    	return id1;
//    }
    public List<Vote> selectVoteById(String name) {
    	int id = userDao.findId(name);
    	System.out.println(id);
    	return userDao.selectVoteById(id);
    }
    public void modifyUser(User user) {
    	System.out.println("auser_id:"+user.getId());
    	userDao.modifyUser(user);
    }
    public void deleteUser(User user) {
    	userDao.deleteUser(user);
    }
    public User selectUserById(int id) {
    	return userDao.selectUserById(id);
    }
}
