package com.example.demo.model.dao;

import java.lang.reflect.Array;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.model.bean.VoteData;

@Mapper
public interface VoteDataDao {
	
	void insertVoteData(VoteData votedata);
	void deleteAllVoteData();
	void deleteAData(int id);
	void increaseFirstNum(int id);
	void increaseSecondNum(int id);
	void increaseThirdNum(int id);
	VoteData selectVoteId(int id);
	List<VoteData> selectAllVote();
}
