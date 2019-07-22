package com.example.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BaseController {
	
	/**
	 * 欢迎界面
	 * @return
	 */
	@RequestMapping(value="welcome")
	public ModelAndView index() {
		return new ModelAndView("welcome");
	}
}
