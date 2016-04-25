package com.tony.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.tony.commons.dao.BaseWeatherDao;
import com.tony.commons.service.impl.BaseWeatherServiceImpl;
import com.tony.dao.WeatherInfoMapper;
import com.tony.entity.WeatherInfo;
import com.tony.service.WeatherSerivce;
@Service("weatherService")
@Transactional
public class WeatherServiceImpl extends BaseWeatherServiceImpl<WeatherInfo,Integer> implements WeatherSerivce{

	@Autowired
	private WeatherInfoMapper weatherInfoDao;

	@Override
	protected BaseWeatherDao<WeatherInfo, Integer> getDao() {
		// TODO Auto-generated method stub
		return weatherInfoDao;
	}
	
	@Override
	public int save(WeatherInfo weatherInfo){
		if(weatherInfoDao.find(weatherInfo)!=null){
			int weatherId = weatherInfoDao.find(weatherInfo).getWeatherId();
			weatherInfo.setWeatherId(weatherId);
			weatherInfo.setPrimaryKey(weatherId);
			return getDao().updateByPrimaryKey(weatherInfo);
		}else{
			return getDao().insert(weatherInfo);
		}
			
	}
	
}
