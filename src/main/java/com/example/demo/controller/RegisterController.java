package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.bean.Admin;
import com.example.demo.model.bean.User;
import com.example.demo.model.bean.Voter;
import com.example.demo.model.dao.UserDao;
import com.example.demo.model.service.AdminService;
import com.example.demo.model.service.UserService;
import com.example.demo.model.service.VoterService;

@RestController
//@RequestMapping(value="/regist")
public class RegisterController{
	@Autowired
	private UserService userService;
	@Autowired
	private VoterService voterService;
	@Autowired
	private AdminService adminService;
	//@GetMapping("index2.do")
	/* 创建投票者界面 */
	@RequestMapping(value="regist")
	public ModelAndView regist() {
		return new ModelAndView("regist"); // 此处指向注册界面
	}
	/* 投票者界面 */
	@RequestMapping(value="voterregist")
	public ModelAndView voterRegist() {
		return new ModelAndView("voterregist"); // 此处指向注册界面
	}
	
	@PostMapping(value = "/testmodify", headers = "Accept=application/json")//接受ajax数据
	public int modify(@RequestBody User user){ //修改个人信息
		
		System.out.println(user);
	    int result = 1;
	    System.out.println(user.getAddress());
	    userService.updateByName(user); //获取所有用户名
	    return result;
	}

	/* 创建投票者注册 */
	@PostMapping(value = "/testadd", headers = "Accept=application/json")//接受ajax数据
	public int reg(@RequestBody User user){  //注册
		
		System.out.println(user);
	    int result = 1;

	    List<User> u = userService.findAllUserName(); //获取所有用户名
	    
	    System.out.println(user.getPassword());
	    for (int i=0; i < u.size() ; i++){ //遍历用户名跟获取到的用户名比较
	    	//System.out.println(u.get(i).getName());
	        if (u.get(i).getName().equals(user.getName())){
	            result = 0;   //用户名已经被注册
	        }
	    }
	    if (user.getName().equals("")) {
	        result = 2;    //密码不能为空
	    }else if (user.getName().equals("")) {
	        result = 3;    //账号不能为空
	    }
	    if (result == 1){
	        userService.add(user);
	    }
	    return result;
	}
	
	/* 投票者注册 */
	@PostMapping(value = "/voterregist", headers = "Accept=application/json")//接受ajax数据
	public int voterRegist(@RequestBody Voter voter){  //注册
		
		System.out.println("voter:"+voter);
	    int result = 1;

	    List<Voter> v = voterService.findAllVoterName(); //获取所有用户名
	    
	    System.out.println("voterpass:"+voter.getVoterPassword());
	    for (int i=0; i < v.size() ; i++){ //遍历用户名跟获取到的用户名比较
	    	//System.out.println(u.get(i).getName());
	        if (v.get(i).getVoterName().equals(voter.getVoterName())){
	            result = 0;   //用户名已经被注册
	        }
	    }
	    if (voter.getVoterName().equals("")) {
	        result = 2;    //密码不能为空
	    }else if (voter.getVoterName().equals("")) {
	        result = 3;    //账号不能为空
	    }
	    if (result == 1){
	        voterService.add(voter);
	    }
	    return result;
	}
	/* 管理员注册 */
	@PostMapping(value = "/adminregist", headers = "Accept=application/json")//接受ajax数据
	public int adminRegist(@RequestBody Admin admin){  //注册
		
		System.out.println("voter:"+admin);
	    int result = 1;

	    List<Admin> v = adminService.findAllAdminName(); //获取所有用户名
	    
	    System.out.println("voterpass:"+admin.getAdminpassword());
	    for (int i=0; i < v.size() ; i++){ //遍历用户名跟获取到的用户名比较
	    	//System.out.println(u.get(i).getName());
	        if (v.get(i).getAdminname().equals(admin.getAdminname())){
	            result = 0;   //用户名已经被注册
	        }
	    }
	    if (admin.getAdminpassword().equals("")) {
	        result = 2;    //密码不能为空
	    }else if (admin.getAdminname().equals("")) {
	        result = 3;    //账号不能为空
	    }
	    if (result == 1){
	        adminService.add(admin);
	    }
	    return result;
	}

}
