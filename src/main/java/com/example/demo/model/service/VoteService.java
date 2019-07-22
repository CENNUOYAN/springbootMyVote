package com.example.demo.model.service;

import java.lang.reflect.Array;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.bean.User;
import com.example.demo.model.bean.Vote;
import com.example.demo.model.bean.Voter;
import com.example.demo.model.dao.VoteDao;

@Service
@Transactional
public class VoteService {

	@Autowired
	private VoteDao voteDao;
	
	public void add(Vote vote) {
		System.out.println("uid="+vote.getVoteUid());
		voteDao.add(vote);
	}
//	public User findById(int id) {
//        Vote vote = new Vote();
//        vote.setId(id);
//        return userDao.findOne(user);
//    }
	public List<Vote> findvote(String name) {
		return voteDao.findvote(name);
	}
	public Vote selectVoteId(int id) {
		return voteDao.selectVoteId(id);
	}
	public List<Vote> selectVoteById(int id) {
		return voteDao.selectVoteById(id);
	}
	public void modifyVote(Vote vote) {
		voteDao.modifyVote(vote);
	}
	public void delete(int id) {
		voteDao.delete(id);
	}
	public List<Vote> findAllVote() {
		return voteDao.findAllVote();
	}
	public void updateVoterId(Vote vote) {
		voteDao.updateVoterId(vote);
	}
}
