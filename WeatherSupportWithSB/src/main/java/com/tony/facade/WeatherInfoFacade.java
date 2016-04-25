package com.tony.facade;

import com.tony.request.WeatherInfoRequest;
import com.tony.response.WeatherInfoResponse;

public interface WeatherInfoFacade {
	public WeatherInfoResponse getWeather(WeatherInfoRequest request);
}
