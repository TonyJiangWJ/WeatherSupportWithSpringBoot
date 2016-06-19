package com.tony.response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tony.commons.response.BaseResponse;

public class WeatherInfoResponse extends BaseResponse{
	
	private JSONObject WeatherInfo;
	
	private Logger logger = LoggerFactory.getLogger(WeatherInfoResponse.class);
	
	public JSONObject getWeatherInfo() {
//		logger.info("WeatherInfo:{}",WeatherInfo.toJSONString());
		return WeatherInfo;
	}

	public void setWeatherInfo(JSONObject weatherInfo) {
		WeatherInfo = weatherInfo;
	}
	
	
}
