package com.tony.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tony.commons.dao.BaseWeatherDao;
import com.tony.commons.service.impl.BaseWeatherServiceImpl;
import com.tony.dao.AqiMapper;
import com.tony.entity.Aqi;
import com.tony.service.AqiService;
@Transactional
@Service("aqiService")
public class AqiServiceImpl extends BaseWeatherServiceImpl<Aqi,Integer> implements AqiService{

	@Autowired
	private AqiMapper aqiDao;

	@Override
	protected BaseWeatherDao<Aqi, Integer> getDao() {
		// TODO Auto-generated method stub
		return aqiDao;
	}


}
