package com.example.demo.model.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.bean.VoterHasVote;

@Mapper
public interface VoterHasVoteDao {
	
	void insertVoterAndVote(VoterHasVote voterHasVote);
	List<VoterHasVote> selectVoteIdByVoterId(VoterHasVote voterHasVote);
	void deleteAllByVoterId(int id);
	VoterHasVote findVoteIdByVoterId(int id);
}
