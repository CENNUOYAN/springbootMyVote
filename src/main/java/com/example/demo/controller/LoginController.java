package com.example.demo.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.util.IOUtils;
import com.example.demo.model.bean.User;
import com.example.demo.model.bean.Vote;
import com.example.demo.model.bean.Voter;
import com.example.demo.model.dao.UserDao;
import com.example.demo.model.service.UserService;
import com.example.demo.model.service.VoteService;
import com.example.demo.model.service.VoterService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// @RestController = @Controller + @ResponseBody
@Controller
public class LoginController {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserService userService;
	@Autowired
	private VoteService voteService;
	@Autowired
	private VoterService voterService;
	
	@GetMapping(value = "")
	public String index() {
		return "login"; // 此处表示返回值是一个值为“login”的String。不指向界面的原因是类的注解是@RestController
	}
	
//	创建投票者登录界面
	@GetMapping(value = "login")
	public ModelAndView login() {
		return new ModelAndView("login"); // 此处指向界面
	}
//	创建投票者登录界面
	@GetMapping(value = "voterlogin")
	public ModelAndView voterLogin() {
		return new ModelAndView("voterlogin"); // 此处指向界面
	}
//	创建投票者登录成功界面
	@GetMapping(value = "voter")
	public ModelAndView voter() {
		return new ModelAndView("voter"); // 此处指向界面
	}
	
	@RequestMapping("login1.do")
	//@RequestBody
    public String helloHtml(String name, String password,HashMap<String, Object> map, Model model) {
		System.out.println("传入参数：name1=" + name + ", password1=" + password);
		User user= userDao.find(name, password);
        ObjectMapper mapper = new ObjectMapper();
        String json="";
 
        try {
            json = mapper.writeValueAsString(user);
 
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
 
        String jsonpString="data="+json;
        System.out.println("传入参数:" + user );
        model.addAttribute("say",user);
        map.put("hello", "欢迎进入HTML页面");
        return "test";
    }
	
//	创建投票者登录
	@RequestMapping(value = "login.do")
	public Object login(String name, String password,HttpServletResponse response,HttpSession session, Model model) {
		System.out.println("传入参数：name=" + name + ", password=" + password);
		if (StringUtils.isEmpty(name)) {
			return "name不能为空";
		} else if (StringUtils.isEmpty(password)) {
			return "password不能为空";
		}
		User user = userDao.find(name, password);
		session.setAttribute("User", user);
		if (user != null)
		{
			System.out.println(user);
			//response.sendRedirect("onvote"); //当使用@RestController才用
			return "index";
		} else {
			return "login";
		}
	}

}