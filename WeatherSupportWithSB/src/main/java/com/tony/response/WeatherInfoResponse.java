package com.tony.response;

import com.alibaba.fastjson.JSONObject;
import com.tony.commons.response.BaseResponse;

public class WeatherInfoResponse extends BaseResponse{
	private JSONObject WeatherInfo;

	public JSONObject getWeatherInfo() {
		return WeatherInfo;
	}

	public void setWeatherInfo(JSONObject weatherInfo) {
		WeatherInfo = weatherInfo;
	}
	
	
}
