package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.bean.Admin;
import com.example.demo.model.bean.User;
import com.example.demo.model.bean.Vote;
import com.example.demo.model.bean.VoteData;
import com.example.demo.model.bean.Voter;
import com.example.demo.model.service.AdminService;
import com.example.demo.model.service.UserService;
import com.example.demo.model.service.VoteDataService;
import com.example.demo.model.service.VoteService;
import com.example.demo.model.service.VoterService;

@Controller
public class AdminController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private User user;
	@Autowired
	private Voter voter;
	@Autowired
	private VoterService voterService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private VoteService voteService;
	@Autowired
	private VoteDataService voteDataService;
	
	// 此处指向管理登录界面
	@RequestMapping(value="adminlogin")
	public ModelAndView adminlogin() {
		return new ModelAndView("adminlogin"); 
	}
	// 此处指向管理注册界面
	@RequestMapping(value="adminregist")
	public ModelAndView adminregist() {
		return new ModelAndView("adminregist"); 
	}
	// 此处指向管理首页界面
	@RequestMapping(value="admin")
	public ModelAndView admin() {
		return new ModelAndView("admin"); 
	}
	// 此处指向管理用户界面
	@RequestMapping(value="adminuser")
	public ModelAndView adminuser(Model model, HashMap<String, Object> map) {
		List<User> user = userService.findAllUserName();
		List<Voter> voter = voterService.findAllVoterName();
		System.out.println("aaa1:"+voter);
		model.addAttribute("user",user);
		map.put("voter", voter);
		return new ModelAndView("adminuser"); 
	}
	// 此处指向管理投票界面
	@RequestMapping(value="adminvote")
	public ModelAndView adminvote(Model model) {
		List<Vote> vote = voteService.findAllVote();
		model.addAttribute("vote",vote);
		return new ModelAndView("adminvote"); 
	}
	// 此处指向管理投票数据界面
	@RequestMapping(value="allvotedata")
	public ModelAndView allvotedata(Model model, HashMap<String, Object> map) {
		List<Vote> vote = voteService.findAllVote();
		List<VoteData> vdata = voteDataService.selectAllVote();
		model.addAttribute("vote",vote);
		map.put("vdata", vdata);
		return new ModelAndView("allvotedata"); 
	}
	// 此处指向管理个人中心界面
	@RequestMapping(value="adminpersonal")
	public ModelAndView adminpersonal(HttpSession session, Model model) {
		Admin admin = (Admin) session.getAttribute("admin");
		model.addAttribute("admin",admin);
		return new ModelAndView("adminpersonal"); 
	}
	
	@GetMapping(value = "admindelete")
	public String adminDelete(int id) {
		System.out.println("delete:" + id);
		voteDataService.deleteAData(id);//想要删除vote必须先删除vote表关联外键的另一个表votedata的一条记录。
		voteService.delete(id); //调用voteService的delete()方法
		return "admin";
	}
	
	@GetMapping("adminresult")
	public String adminResult(int id, Model model) {
		String url = "result.html";
		System.out.println("adminvote id: " + id);
		Vote vote = voteService.selectVoteId(id);
		VoteData vdata = voteDataService.selectVoteId(id);
		model.addAttribute("vdata",vdata);
		model.addAttribute("vote", vote);
		return url;
	}
	/**
	 * 管理员删除用户发布者
	 * @param id
	 * @return
	 */
	@GetMapping(value = "deleteUser")
	public String deleteUser(int id) {
		System.out.println("delete:" + id);
		user.setId(id);
		userService.deleteUser(user); //调用voteService的delete()方法
		return "adminuser";
	}
	/**
	 * 管理员删除用户投票者
	 * @param id
	 * @return
	 */
	@GetMapping(value = "deleteVoter")
	public String deleteVoter(int id) {
		System.out.println("delete:" + id);
		voter.setVoterId(id);
		voterService.deleteVoter(voter); //调用voteService的delete()方法
		return "adminuser";
	}
	/**
	 * 跳转到管理员修改用户发布者密码界面
	 * @param id
	 * @param model
	 * @param session
	 * @return
	 */
	@GetMapping(value = "exitUserPassword")
	public String exitUserPassword(int id, Model model, HttpSession session) {
		System.out.println("delete:" + id);
		user.setId(id);
		User user = userService.selectUserById(id);
		model.addAttribute("user",user);
		session.setAttribute("userid",id);
		return "modifyuser";
	}
	
	/**
	 * 管理员修改用户发布者密码
	 * @param session
	 * @param user
	 * @return
	 */
	@PostMapping(value = "/adminmodifyuser", headers = "Accept=application/json")
	@ResponseBody
	public int modifyUser(HttpSession session, @RequestBody User user) {
		int id = (int) session.getAttribute("userid");
		user.setId(id);
		System.out.println("user:"+user.getPassword());
		System.out.println("user_id:"+id);
		userService.modifyUser(user);
		System.out.println("useraaa:");
		return 1;
	}
	
	
	/**
	 * 跳转到管理员修改用户投票者密码界面
	 * @param id
	 * @param model
	 * @param session
	 * @return
	 */
	@GetMapping(value = "exitVoterPassword")
	public String exitVoterPassword(int id, Model model, HttpSession session) {
		System.out.println("delete:" + id);
		voter.setVoterId(id);
		Voter voter = voterService.selectVoterById(id);
		model.addAttribute("voter",voter);
		session.setAttribute("voterid",id);
		return "modifyvoter";
	}
	
	/**
	 * 管理员修改用户投票者密码
	 * @param session
	 * @param user
	 * @return
	 */
	@PostMapping(value = "/adminmodifyvoter", headers = "Accept=application/json")
	@ResponseBody
	public int modifyVoter(HttpSession session, @RequestBody Voter voter) {
		int id = (int) session.getAttribute("voterid");
		voter.setVoterId(id);
		System.out.println("user_id:"+id);
		voterService.modifyVoter(voter);
		System.out.println("useraaa:");
		return 1;
	}
}
