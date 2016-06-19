package com.tony.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tony.commons.dao.BaseDao;
import com.tony.commons.service.impl.BaseServiceImpl;
import com.tony.dao.CityMapper;
import com.tony.entity.City;
import com.tony.service.CityInfoService;
@Transactional
@Service("cityInfoService")
public class CityInfoServiceImpl extends BaseServiceImpl<String, City> implements CityInfoService{
	@Autowired
	private CityMapper cityDao;

	@Override
	protected BaseDao<City, String> getDao() {
		// TODO Auto-generated method stub
		return cityDao;
	}

	@Override
	public List<City> PageCity(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return cityDao.page(map);
	}
	
	
}
