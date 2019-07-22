package com.example.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.bean.VoteData;
import com.example.demo.model.dao.VoteDataDao;

@Service
public class VoteDataService {
	
	@Autowired
	private VoteDataDao voteDataDao;
	
//	public void increase();
	public void insertVoteData(VoteData votedata ) {
		System.out.println("VOTE_ID1:"+votedata.getVoteid());
		voteDataDao.insertVoteData(votedata);
	}
	public void deleteAllVoteData() {
		voteDataDao.deleteAllVoteData();
	}
	public void deleteAData(int id) {
		voteDataDao.deleteAData(id);
	}
	public void increaseFirstNum(int id) {
		voteDataDao.increaseFirstNum(id);
	}
	public void increaseSecondNum(int id) {
		voteDataDao.increaseSecondNum(id);
	}
	public void increaseThirdNum(int id) {
		voteDataDao.increaseThirdNum(id);
	}
	public VoteData selectVoteId(int id) {
		System.out.println("VOTEdataid:" + id);
		return voteDataDao.selectVoteId(id);
	}
	public List<VoteData> selectAllVote(){
		return voteDataDao.selectAllVote();
	}
}
