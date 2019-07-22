package com.example.demo.model.bean;

import java.io.Serializable;

import org.springframework.stereotype.Service;

@Service
public class VoteData implements Serializable{
	
	private static final long serialVersionUID = -5611386225028407298L;
	
	private Integer dataid;

	private Integer voteid;
	private Integer firstNum;
	private Integer secondNum;
	private Integer thirdNum;
	private Integer fourNum;
	private Integer fiveNum;
	private Integer sixNum;
	public Integer getDataid() {
		return dataid;
	}
	public void setDataId(Integer dataId) {
		this.dataid = dataId;
	}
	public Integer getVoteid() {
		return voteid;
	}
	public void setVoteid(Integer voteid) {
		this.voteid = voteid;
	}
	public Integer getFirstNum() {
		return firstNum;
	}
	public void setFirstNum(Integer firstNum) {
		this.firstNum = firstNum;
	}
	public Integer getSecondNum() {
		return secondNum;
	}
	public void setSecondNum(Integer secondNum) {
		this.secondNum = secondNum;
	}
	public Integer getThirdNum() {
		return thirdNum;
	}
	public void setThirdNum(Integer thirdNum) {
		this.thirdNum = thirdNum;
	}
	public Integer getFourNum() {
		return fourNum;
	}
	public void setFourNum(Integer fourNum) {
		this.fourNum = fourNum;
	}
	public Integer getFiveNum() {
		return fiveNum;
	}
	public void setFiveNum(Integer fiveNum) {
		this.fiveNum = fiveNum;
	}
	public Integer getSixNum() {
		return sixNum;
	}
	public void setSixNum(Integer sixNum) {
		this.sixNum = sixNum;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
}
