package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.bean.Admin;
import com.example.demo.model.bean.User;
import com.example.demo.model.bean.Voter;
import com.example.demo.model.service.AdminService;
import com.example.demo.model.service.UserService;
import com.example.demo.model.service.VoteService;
import com.example.demo.model.service.VoterService;

@RestController
public class PersonalController {
	
	@Autowired
	private UserService UserService;
	
	@Autowired
	private VoterService voterService;
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="personal")
	public ModelAndView index(Model model, HttpSession session) {
		User user = (User) session.getAttribute("User");
		//int id = user.getId();
		//user.setId(id);
		model.addAttribute("user",user);
		return new ModelAndView("personal");
	}
	
	@RequestMapping(value="voterpersonal")
	public ModelAndView voterPersonal(Model model, HttpSession session) {
		Voter voter = (Voter) session.getAttribute("voter");
//		//int id = user.getId();
//		//user.setId(id);
		model.addAttribute("voter",voter);
		return new ModelAndView("voterpersonal");
	}
	
//	修改用户信息
	@PostMapping(value = "/modifyuser", headers = "Accept=application/json")
	public int modifyUser(HttpSession session, @RequestBody User user) {
		User user1 = (User) session.getAttribute("User");
		int id = user1.getId();
		String password = user.getPassword();
		user.setId(id);
		System.out.println("user_id:"+password);
		UserService.modifyUser(user);
		return 1;
	}
	
//	修改投票者信息
	@PostMapping(value = "/modifyvoter", headers = "Accept=application/json")
	@ResponseBody
	public int modifyVoter(HttpSession session, @RequestBody Voter voter) {
		Voter voter2 = (Voter) session.getAttribute("voter");
		System.out.println("user_id1:"+voter2.getVoterPassword()+"id:"+voter2.getVoterId());
		int id = voter2.getVoterId();
		System.out.println("user_id2:"+id);
		String password = voter.getVoterPassword();
		System.out.println("user_id3:");
		voter.setVoterId(id);
		System.out.println("user_id:"+password);
		voterService.modifyVoter(voter);
		return 1;
	}
//	修改管理员信息
	@PostMapping(value = "/modifyadmin", headers = "Accept=application/json")
	@ResponseBody
	public int modifyAdmin(HttpSession session, @RequestBody Admin admin) {
		Admin admin2 = (Admin) session.getAttribute("admin");
		
		int id = admin2.getAdminid();
		System.out.println("admin_id2:"+id);
		admin.setAdminid(id);
		adminService.modifyAdmin(admin);
		return 1;
	}
}
