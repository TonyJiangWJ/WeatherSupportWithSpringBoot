package com.tony.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tony.facade.LoginFacade;
import com.tony.request.UserRequest;

@Controller
public class LoginAction {
	@Autowired
	private LoginFacade loginFacade;
	
	@ResponseBody
	@RequestMapping("/login/get")
	public Object login(@ModelAttribute("request") UserRequest request){
		return loginFacade.login(request);
	}
	
	@ResponseBody
	@RequestMapping("/login/put")
	public Object register(@ModelAttribute("request") UserRequest request){
		return loginFacade.register(request);
	}
	
	@ResponseBody
	@RequestMapping("/login/update")
	public Object update(@ModelAttribute("request") UserRequest request){
		return loginFacade.updateInfo(request);
	}
	
	@ResponseBody
	@RequestMapping("/login/reset/password")
	public Object resetPassword(@ModelAttribute("request") UserRequest request){
		return loginFacade.reSetPassword(request);
	}
}
