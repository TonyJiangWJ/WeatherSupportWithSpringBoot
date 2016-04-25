package com.tony.dao;

import com.tony.commons.dao.BaseWeatherDao;
import com.tony.entity.WeatherInfo;

public interface WeatherInfoMapper extends BaseWeatherDao<WeatherInfo, Integer>{
	public WeatherInfo find(WeatherInfo weatherInfo);
}