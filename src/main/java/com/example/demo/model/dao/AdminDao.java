package com.example.demo.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.bean.Admin;

@Mapper
public interface AdminDao {
	void add(Admin admin);

	void modifyAdmin(Admin admin);
	List<Admin> findAllAdminName();
	Admin findAllAdminByName(Admin admin);
}
