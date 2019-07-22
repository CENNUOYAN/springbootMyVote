package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.bean.Admin;
import com.example.demo.model.bean.Voter;
import com.example.demo.model.service.AdminService;
import com.example.demo.model.service.UserService;
import com.example.demo.model.service.VoteService;
import com.example.demo.model.service.VoterService;

@RestController
public class VoterLoginController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private VoteService voteService;
	@Autowired
	private VoterService voterService;
	@Autowired
	private AdminService adminService;
	
	/**
	 * 用户voter
	 * 投票者登录
	 * @param voter
	 * @param session
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/voterlogin", headers = "Accept=application/json")//接受ajax数据
	public int voterLogin(@RequestBody Voter voter, HttpSession session, Model model) {
		
		int result=111;
		List<Voter> v = voterService.findAllVoterName(); //获取所有用户名
		Voter voter2 = voterService.findAllVoter(voter); //根据voter中的用户名在voter表找到当前登陆的voter信息
		session.setAttribute("voter", voter2);   //将voter2保存到session
		
	    for (int i=0; i < v.size() ; i++){ //遍历用户名跟获取到的用户名比较
	    	
	        if (v.get(i).getVoterName().equals(voter.getVoterName())&&v.get(i).getVoterPassword().equals(voter.getVoterPassword())) {  //验证用户名和密码
	        	System.out.println(v.get(i).getVoterPassword());
	            result = 1;   //登录成功
	            return 1;
	        }
	        else {
				result = 0;
			}
	    }
	    if (voter.getVoterName().equals("")) {
	        result = 2;    //密码不能为空
	    }else if (voter.getVoterName().equals("")) {
	        result = 3;    //账号不能为空
	    }
	    return result;
		
	}
	/**
	 * 管理者admin
	 * 管理者登录
	 * @param admin
	 * @param session
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/adminlogin", headers = "Accept=application/json")//接受ajax数据
	public int adminLogin(@RequestBody Admin admin, HttpSession session, Model model) {

		int result=111;
		List<Admin> v = adminService.findAllAdminName(); //获取所有用户名
		Admin admin2 = adminService.findAllAdminByName(admin); //根据管理者名称找到当前的管理者信息
		session.setAttribute("admin", admin2);  //保存到session
	    for (int i=0; i < v.size() ; i++){ //遍历用户名跟获取到的用户名比较
	        if (v.get(i).getAdminname().equals(admin.getAdminname())&&
	      v.get(i).getAdminpassword().equals(admin.getAdminpassword())){  //验证用户名和密码
	        	System.out.println(v.get(i).getAdminpassword());
	            result = 1;   //登录成功
	            return 1;
	        }
	        else {
				result = 0;
			}
	    }
	    if (admin.getAdminpassword().equals("")) {
	        result = 2;    //密码不能为空
	    }else if (admin.getAdminname().equals("")) {
	        result = 3;    //账号不能为空
	    }
	    return result;
		
	}


}
