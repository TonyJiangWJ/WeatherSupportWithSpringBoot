package com.tony.dao;

import java.util.List;
import java.util.Map;

import com.tony.commons.dao.BaseDao;
import com.tony.entity.City;

public interface CityMapper extends BaseDao<City, String>{
	public List<City> page(Map<String, Integer> map);
}