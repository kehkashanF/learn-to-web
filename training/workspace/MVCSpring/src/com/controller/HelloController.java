package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
		
	@RequestMapping("/hello")
	public ModelAndView printHello(){
		
		return new ModelAndView("hello", "message", "aga bai! kasa kaay??");
	}
	
	@RequestMapping("/add")
	public ModelAndView addMe(HttpServletRequest request){
		String uname=request.getParameter("username");
		String pword=request.getParameter("password");
		return new ModelAndView("welcome", "message", uname+" welcome");
	}
	
	//RequestParam can only read primitive data types
	@RequestMapping("/add_new")
	public ModelAndView addNew(@RequestParam("username") String username, @RequestParam("password") String password){
		return new ModelAndView("welcome","message",username+" welcome");
	}
}
