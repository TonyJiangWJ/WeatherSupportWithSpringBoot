package com.tony.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tony.commons.dao.BaseWeatherDao;
import com.tony.commons.service.impl.BaseWeatherServiceImpl;
import com.tony.dao.ForecastMapper;
import com.tony.entity.Forecast;
import com.tony.service.ForecastService;
@Transactional
@Service("forecastService")
public class ForecastServiceImpl extends BaseWeatherServiceImpl< Forecast,Integer> implements ForecastService {

	@Autowired
	private ForecastMapper forecastDao;
	@Override
	protected BaseWeatherDao<Forecast, Integer> getDao() {
		// TODO Auto-generated method stub
		return forecastDao;
	}
	
}
