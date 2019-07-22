package com.example.demo.model.bean;
import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class User implements Serializable {
	
	private static final long serialVersionUID = -5611386225028407298L;
	
	private Integer id;
	private String name;
	private String password;
	private String address;
	private List<Vote> votes;
	
	public User() {
		
	}
	
	public List<Vote> getVotes() {
		return votes;
	}
	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String toString() {
		return "id:"+this.id+" name:"+this.name;
	}

    
}

