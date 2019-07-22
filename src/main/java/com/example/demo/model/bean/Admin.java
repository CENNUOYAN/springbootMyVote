package com.example.demo.model.bean;
import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class Admin implements Serializable {
	
	private static final long serialVersionUID = -5611386225028407298L;
	
	private Integer adminid;
	private String adminname;
	private String adminpassword;


	public Integer getAdminid() {
		return adminid;
	}


	public void setAdminid(Integer adminid) {
		this.adminid = adminid;
	}


	public String getAdminname() {
		return adminname;
	}


	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}


	public String getAdminpassword() {
		return adminpassword;
	}


	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String toString() {
		return "id:"+this.adminid+" name:"+this.adminname;
	}

    
}


