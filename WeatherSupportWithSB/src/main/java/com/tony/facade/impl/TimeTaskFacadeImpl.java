package com.tony.facade.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tony.entity.City;
import com.tony.facade.TimeTaskFacade;
import com.tony.facade.WeatherInfoFacade;
import com.tony.service.CityInfoService;
@Service("timeTaskFacade")
public class TimeTaskFacadeImpl implements TimeTaskFacade{
	private Timer timer;
	private TimerTask task;
	private Calendar calendar;
	private Date date;
	private int count;
	private Map<String, Integer> map;
	long period = 3600*1000;//两秒
	@Autowired
	private CityInfoService cityInfoService;
	@Autowired
	private WeatherInfoFacade weatherInfoFacade;
	
	private Logger logger = LoggerFactory.getLogger(TimeTaskFacadeImpl.class);
	public void Init(){
		timer = new Timer();
		calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.set(year, month, day, 01, 10, 10);
		date = calendar.getTime();
		count=0;
		map = new HashMap<>();
		map.put("index", 0);
		map.put("offset", 100);
		
		
		task = new TimerTask() {
			@Override
			public void run() {
			
				List<City> cityList = cityInfoService.PageCity(map);
				logger.info("outside while map index:",map.get("index"));
				
				while(cityList!=null&&cityList.size()>0){
					
					for(City city:cityList){
						String cityCode = city.getCityCode();
						logger.info("city:{},code:{}",city.getTownName(),cityCode);
						weatherInfoFacade.updateWeather(cityCode);
					}
					map.put("index", map.get("index")+map.get("offset"));
					logger.info("Map index:{}",map.get("index"));
					cityList = cityInfoService.PageCity(map);
				}
			}
		};
	}
	@Override
	public void DoTask() {
		Init();
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				timer.schedule(task, date, period);
			}
		});
		thread.start();
		logger.info("TaskStart");
	}

}
