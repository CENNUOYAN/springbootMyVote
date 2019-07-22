package com.example.demo.model.bean;
import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class Voter implements Serializable {
	
	private static final long serialVersionUID = -5611386225028407298L;
	
	private Integer voterId;
	private String voterName;
	private String voterPassword;
	public String getVoterPassword() {
		return voterPassword;
	}


	public void setVoterPassword(String voterPassword) {
		this.voterPassword = voterPassword;
	}


	private String address;
	private List<Vote> votes;
	
	public Integer getVoterId() {
		return voterId;
	}


	public void setVoterId(Integer voterId) {
		this.voterId = voterId;
	}


	public String getVoterName() {
		return voterName;
	}


	public void setVoterName(String voterName) {
		this.voterName = voterName;
	}





	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public List<Vote> getVotes() {
		return votes;
	}


	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}


	public Voter() {
		
	}
	
	
	public String toString() {
		return "id:"+this.voterId+" name:"+this.voterName;
	}

    
}


