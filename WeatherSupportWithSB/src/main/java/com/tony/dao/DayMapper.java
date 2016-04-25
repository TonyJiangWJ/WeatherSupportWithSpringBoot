package com.tony.dao;

import java.util.List;

import com.tony.commons.dao.BaseWeatherDao;
import com.tony.entity.Day;

public interface DayMapper extends BaseWeatherDao<Day, Integer>{
	public List<Day> selectListByWeatherId(int weatherId);
}