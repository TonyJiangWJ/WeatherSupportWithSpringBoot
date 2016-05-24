package com.tony.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.tony.facade.WeatherInfoFacade;
import com.tony.request.WeatherInfoRequest;

@Controller
@RequestMapping("/weather")
public class WeatherInfoAction {

	@Autowired
	private WeatherInfoFacade weatherInfoFacade;
	private Logger logger = LoggerFactory.getLogger(WeatherInfoAction.class);
	
	
	@ResponseBody
	@RequestMapping("/get")
	public Object getWeather(@ModelAttribute("request")WeatherInfoRequest request){
//		return JSON.toJSONString(weatherInfoFacade.getWeather(request),features);
		logger.info("WeatherRequest:{}",JSON.toJSONString(request));
		Object response = weatherInfoFacade.getWeather(request);
		logger.info("Response:{}",JSON.toJSONString(response));
		return JSON.toJSONString(response);
	}
}
