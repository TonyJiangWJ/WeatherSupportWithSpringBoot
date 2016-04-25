package com.tony.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tony.commons.dao.BaseWeatherDao;
import com.tony.commons.service.impl.BaseWeatherServiceImpl;
import com.tony.dao.RealtimeMapper;
import com.tony.entity.Realtime;
import com.tony.service.RealtimeService;
@Transactional
@Service("resltimeService")
public class RealtimeServiceImpl extends BaseWeatherServiceImpl<Realtime, Integer> implements RealtimeService{
	@Autowired
	private RealtimeMapper realtimeDao;

	@Override
	protected BaseWeatherDao<Realtime, Integer> getDao() {
		// TODO Auto-generated method stub
		return realtimeDao;
	}


	
	

}
