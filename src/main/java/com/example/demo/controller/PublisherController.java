package com.example.demo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.bean.User;
import com.example.demo.model.dao.UserDao;

// @RestController = @Controller + @ResponseBody
@Controller
public class PublisherController {
	
	@Autowired
	private UserDao userDao;
	
	@GetMapping(value = "publisherlogin")
	public ModelAndView publisher2() {
		return new ModelAndView("publisherlogin"); // 此处指向界面
	}
	
	@RequestMapping(value = "publisherlogin.do")
	public Object login(String name, String password,HttpServletResponse response,Model model) {
		System.out.println("传入参数：name=" + name + ", password=" + password);
		if (StringUtils.isEmpty(name)) {
			return "name不能为空";
		} else if (StringUtils.isEmpty(password)) {
			return "password不能为空";
		}
		User user = userDao.find(name, password);
		model.addAttribute("user",user);
        System.out.println("传入参数:" + user );
		if (user != null)
		{
			System.out.println(user);
			//response.sendRedirect("onvote"); //当使用@RestController才用
			return "publishervote";
		} else {
			return "用户名或密码错误";
		}
	}

}
