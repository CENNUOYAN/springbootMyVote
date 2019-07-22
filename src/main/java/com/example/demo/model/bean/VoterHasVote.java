package com.example.demo.model.bean;

import org.springframework.stereotype.Service;

@Service
public class VoterHasVote {
	
	private int voterid;
	private int voteid;
	public int getVoterid() {
		return voterid;
	}
	public void setVoterid(int voterid) {
		this.voterid = voterid;
	}
	public int getVoteid() {
		return voteid;
	}
	public void setVoteid(int voteid) {
		this.voteid = voteid;
	}
	
}
