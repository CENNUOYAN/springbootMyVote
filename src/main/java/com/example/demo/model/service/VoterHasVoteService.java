package com.example.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.bean.VoterHasVote;
import com.example.demo.model.dao.VoterHasVoteDao;

@Service
public class VoterHasVoteService {
	
	@Autowired
	private VoterHasVoteDao voterHasVoteDao;
	
	public void insertVoterAndVote(VoterHasVote voterHasVote) {
		voterHasVoteDao.insertVoterAndVote(voterHasVote);
	}
	public List<VoterHasVote> selectVoteIdByVoterId(VoterHasVote voterHasVote) {
		System.out.println("aaa2");
		return voterHasVoteDao.selectVoteIdByVoterId(voterHasVote);
	}
	public void deleteAllByVoterId(int id) {
		voterHasVoteDao.deleteAllByVoterId(id);
	}
	public VoterHasVote findVoteIdByVoterId(int id) {
		return voterHasVoteDao.findVoteIdByVoterId(id);
	}
}
