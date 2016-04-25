package com.tony.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tony.service.UserService;

@Controller
@RequestMapping("/test")
public class TestAction {
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping("/user/get")
	public Object get(){
		return userService.findByPrimaryKey("asdfasdfasdfa");
	}
}
