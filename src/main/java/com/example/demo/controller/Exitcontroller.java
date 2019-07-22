package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.bean.User;
import com.example.demo.model.bean.Vote;
import com.example.demo.model.service.VoteService;

@Controller
public class Exitcontroller {
	
	@Autowired
	private VoteService voteService;
	
//	编辑页面
	@GetMapping("exit")
	public String handleExit(int id, Model model, HttpSession session) {
		String url = "exit.html";
		int ID = id;
		System.out.println("exit id: "+id);
		session.setAttribute("id",id);
		Vote vote = voteService.selectVoteId(id);
		model.addAttribute("vote",vote);
		return url;
	}
	@GetMapping("exit1 ")
	public int handleExit1(int id, Model model) {
		String url = "exit.html";
		int ID = id;
		System.out.println("exit1 id: "+id);
		return id;
	}
//  编辑投票方法	
	@PostMapping(value="modifyvote", headers = "Accept=application/json")
	@ResponseBody
	public int modify(@RequestBody Vote vote, HttpSession session) {
		int id1 =  (int) session.getAttribute("id");
		//Integer uid = user1.getId();
		vote.setVoteId(id1);
		System.out.println("aaa"+id1);
		voteService.modifyVote(vote);
		System.out.println("modify id: "+id1);
		System.out.println("void="+vote.getVoteTitle());
		return 1;
	}
}
