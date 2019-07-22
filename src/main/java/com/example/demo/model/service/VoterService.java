package com.example.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.bean.User;
import com.example.demo.model.bean.Voter;
import com.example.demo.model.dao.VoteDao;
import com.example.demo.model.dao.VoterDao;

@Service
public class VoterService {
	
	@Autowired
	private VoterDao voterDao;
	
	  //查找所有用户名
    public List<Voter> findAllVoterName() {
        return voterDao.findAllVoterName();
    }
	public void add(Voter voter) {
        voterDao.add(voter);
    }
	public Voter findAllVoter(Voter voter) {
		return voterDao.findAllVoter(voter);
	}
//	public Voter findAllVote() {
//		return voterDao.findAllVote();
//	}
    public void modifyVoter(Voter voter) {
    	System.out.println("avoter_id:"+voter.getVoterId());
    	voterDao.modifyVoter(voter);
    }
    public void deleteVoter(Voter voter) {
    	voterDao.deleteVoter(voter);
    }
    public Voter selectVoterById(int id) {
    	return voterDao.selectVoterById(id);
    }
}
