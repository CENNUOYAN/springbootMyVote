package com.example.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.bean.Admin;
import com.example.demo.model.bean.Voter;
import com.example.demo.model.dao.AdminDao;

@Service
public class AdminService {
	
	@Autowired
	private AdminDao adminDao;
	public void add(Admin admin) {
		adminDao.add(admin);
	}
    public void modifyAdmin(Admin admin) {
    	System.out.println("admin_id:"+admin.getAdminid());
    	adminDao.modifyAdmin(admin);
    }
    public List<Admin> findAllAdminName(){
    	return adminDao.findAllAdminName();
    }
    public Admin findAllAdminByName(Admin admin){
    	return adminDao.findAllAdminByName(admin);
    }
}
