package com.tony.service;

import com.tony.commons.service.BaseWeatherService;
import com.tony.entity.Day;

public interface DayService extends BaseWeatherService<Day, Integer>{
	public Day getToday(int weatherId);
	public Day getYestoday(int weatherId);
}
