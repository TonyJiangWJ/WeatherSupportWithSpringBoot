package com.tony.service;

import java.util.List;
import java.util.Map;

import com.tony.commons.service.BaseService;
import com.tony.entity.City;

public interface CityInfoService extends BaseService<City, String>{
	public List<City> PageCity(Map<String, Integer> map);
}
