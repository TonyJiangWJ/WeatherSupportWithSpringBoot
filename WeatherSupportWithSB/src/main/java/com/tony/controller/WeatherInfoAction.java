package com.tony.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tony.facade.WeatherInfoFacade;
import com.tony.request.WeatherInfoRequest;

@Controller
@RequestMapping("/weather")
public class WeatherInfoAction {

	@Autowired
	private WeatherInfoFacade weatherInfoFacade;
	
	@ResponseBody
	@RequestMapping("/get")
	public Object getWeather(@ModelAttribute("request")WeatherInfoRequest request){
		return weatherInfoFacade.getWeather(request);
	}
}
