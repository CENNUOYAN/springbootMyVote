package com.example.demo.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.bean.User;
import com.example.demo.model.bean.Vote;
import com.example.demo.model.bean.Voter;

@Mapper
public interface VoterDao {
	
	void add(Voter voter);
	List<Voter> findAllVoterName();
	Voter findAllVoter(Voter voter);
//	Voter findAllVote();
	void modifyVoter(Voter voter);
	void deleteVoter(Voter voter);
	Voter selectVoterById(int id);
}
