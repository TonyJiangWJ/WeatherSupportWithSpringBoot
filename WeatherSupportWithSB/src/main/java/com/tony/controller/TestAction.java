package com.tony.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tony.facade.TimeTaskFacade;
import com.tony.service.CityInfoService;
import com.tony.service.UserService;

@Controller
@RequestMapping("/test")
public class TestAction {
	@Autowired
	private UserService userService;
	@Autowired
	private CityInfoService cityInfoService;
	@Autowired
	private TimeTaskFacade timeTaskFacade;
	@ResponseBody
	@RequestMapping("/user/get")
	public Object get(){
		return userService.findByPrimaryKey("asdfasdfasdfa");
	}
	
	@ResponseBody
	@RequestMapping("/city/list")
	public Object list(){
		Map<String, Integer> map = new HashMap<>();
		map.put("index", 0);
		map.put("offset", 100);
		return cityInfoService.PageCity(map);
	}
	@ResponseBody
	@RequestMapping("/task/start")
	public Object task(){
		timeTaskFacade.DoTask();
		return "Started";
	}
}
