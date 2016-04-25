package com.tony.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tony.commons.dao.BaseWeatherDao;
import com.tony.commons.service.impl.BaseWeatherServiceImpl;
import com.tony.dao.DayMapper;
import com.tony.entity.Day;
import com.tony.service.DayService;
@Transactional
@Service("dayService")
public class DayServiceImpl extends BaseWeatherServiceImpl<Day,Integer> implements DayService{

	@Autowired
	private DayMapper dayDao;

	@Override
	protected BaseWeatherDao<Day, Integer> getDao() {
		// TODO Auto-generated method stub
		return dayDao;
	}
	private Day today;
	private Day yestoday;
	private List<Day> twoDay;
	public void getDay(int weatherId){
		if(twoDay==null||twoDay.size()==0){
			twoDay=dayDao.selectListByWeatherId(weatherId);
			if(twoDay.get(0).getDayType()==0){
				yestoday=twoDay.get(0);
				today=twoDay.get(1);
			}else{
				yestoday=twoDay.get(1);
				today=twoDay.get(0);
			}
		}
	}
	
	public Day getToday(int weatherId){
		getDay(weatherId);
		return today;
	}
	public Day getYestoday(int weatherId){
		getDay(weatherId);
		return yestoday;
	}
}
