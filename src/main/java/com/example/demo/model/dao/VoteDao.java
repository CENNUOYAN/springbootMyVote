package com.example.demo.model.dao;

import java.lang.reflect.Array;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.model.bean.Vote;

@Mapper
public interface VoteDao {
	
	void add(Vote vote);
	void add1(@Param("vote")Vote vote, Integer uid);
	
	List<Vote> findvote(String name);
	Vote selectVoteId(int id);
	Vote svid(Array vote);
	void modifyVote(Vote vote);
	void delete(int id);
	List<Vote> findAllVote();
	void updateVoterId(Vote vote);
	List<Vote> selectVoteById(int id);
}
