package com.tony.dao;

import java.util.List;

import com.tony.commons.dao.BaseWeatherDao;
import com.tony.entity.MIndex;

public interface MIndexMapper extends BaseWeatherDao<MIndex, Integer>{
	public List<MIndex> selectListByWeatherId(int weatherId);
}