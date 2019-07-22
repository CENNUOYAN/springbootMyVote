package com.example.demo.model.bean;

import java.io.Serializable;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
@Service
public class Vote implements Serializable {
	
	private static final long serialVersionUID = -5611386225028407298L;
	
	private Integer voteId;
	private Integer VoteUid;
	
	public Integer getVoteUid() {
		return VoteUid;
	}
	public void setVoteUid(Integer voteUid) {
		VoteUid = voteUid;
	}
	private String item;
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	private String voteTitle;
	private String voteStime;
	private String voteEtime;
	private String voteFirstitem;
	private String voteSeconditem;
	private String voteThirditem;
	private String voteNum;
	private int voterid;
	private int firstnum;
	private int secondnum;
	private int thirdnum;
	public int getFirstnum() {
		return firstnum;
	}
	public void setFirstnum(int firstnum) {
		this.firstnum = firstnum;
	}
	public int getSecondnum() {
		return secondnum;
	}
	public void setSecondnum(int secondnum) {
		this.secondnum = secondnum;
	}
	public int getThirdnum() {
		return thirdnum;
	}
	public void setThirdnum(int thirdnum) {
		this.thirdnum = thirdnum;
	}
	public int getVoterid() {
		return voterid;
	}
	public void setVoterid(int voterid) {
		this.voterid = voterid;
	}
	public String getVoteNum() {
		return voteNum;
	}
	public void setVoteNum(String voteNum) {
		this.voteNum = voteNum;
	}
	public Integer getVoteId() {
		return voteId;
	}
	public void setVoteId(Integer voteId) {
		this.voteId = voteId;
	}
	public String getVoteTitle() {
		return voteTitle;
	}
	public void setVoteTitle(String voteTitle) {
		this.voteTitle = voteTitle;
	}
	public String getVoteStime() {
		return voteStime;
	}
	public void setVoteStime(String voteStime) {
		this.voteStime = voteStime;
	}
	public String getVoteEtime() {
		return voteEtime;
	}
	public void setVoteEtime(String voteEtime) {
		this.voteEtime = voteEtime;
	}
	public String getVoteFirstitem() {
		return voteFirstitem;
	}
	public void setVoteFirstitem(String voteFirstitem) {
		this.voteFirstitem = voteFirstitem;
	}
	public String getVoteSeconditem() {
		return voteSeconditem;
	}
	public void setVoteSeconditem(String voteSeconditem) {
		this.voteSeconditem = voteSeconditem;
	}
	public String getVoteThirditem() {
		return voteThirditem;
	}
	public void setVoteThirditem(String voteThirditem) {
		this.voteThirditem = voteThirditem;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String toString() {
		return "id:"+this.voteId+" title:"+this.voteTitle+"item1:"+this.voteFirstitem+"item2:"+this.voteSeconditem+"item3:"+this.voteThirditem;
	}
}
