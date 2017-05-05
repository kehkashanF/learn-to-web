package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.UserDAO;
import com.pojo.Gender;
import com.pojo.User;

@Controller
public class addController {
	
	@Autowired
	Validator validator;
	@Autowired
	UserDAO userDAO;
	
	
	@RequestMapping("/show.htm") //to give back a form, ModelMap map is COMPULSORY
	public ModelAndView showForm(HttpServletRequest request, HttpServletResponse response, ModelMap map) throws Exception{
			User user=new User();
			map.addAttribute(user);
			return new ModelAndView("userForm"); //userForm will be inside the WEB-INF/jsp folder as this form will never be made available to the user
	}
	
	@RequestMapping("/add.htm")
	public ModelAndView addContact(@ModelAttribute("user") User user, BindingResult result) throws Exception{
		validator.validate(user, result);
		if(result.hasErrors()){
			return new ModelAndView("userForm");
		}
		userDAO.addUser(user);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("display");
		modelAndView.addObject("myuser", user);
		return modelAndView;
	}
	
	
	@ModelAttribute("genderList")
	public List<Gender> addGenders() {
		List<Gender> genders=new ArrayList<Gender>();
		Gender genderF=new Gender();
		genderF.setId(1);
		genderF.setValue("Female");
		
		Gender genderM=new Gender();
		genderM.setId(2);
		genderM.setValue("Male");
		
		genders.add(genderF);
		genders.add(genderM);
		return genders;
	}
	
	
	@RequestMapping("/search.htm")
	public ModelAndView searchUser(@RequestParam("email") String email) throws Exception{
		
		
		User user=userDAO.findUser(email);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("display");
		modelAndView.addObject("myuser", user);
		return modelAndView;
		
		
	}
	
	@RequestMapping("/searchAll.htm")
	public ModelAndView searchAllUsers() throws Exception{
		
		
		List<User> list=userDAO.findAllUsers();
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("allUsers");
		modelAndView.addObject("list", list);
		return modelAndView;
		
		
	}
	
	@RequestMapping("/deleteIt.htm")
	public ModelAndView removeUser(@RequestParam("email") String email) throws Exception{
		int record=userDAO.deleteUser(email);
		List<User> list=userDAO.findAllUsers();
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("allUsers");
		modelAndView.addObject("list", list);
		return modelAndView;
	}
}
