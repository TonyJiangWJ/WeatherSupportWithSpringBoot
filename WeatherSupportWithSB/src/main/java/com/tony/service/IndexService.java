package com.tony.service;

import com.tony.commons.service.BaseWeatherService;
import com.tony.entity.MIndex;

public interface IndexService extends BaseWeatherService<MIndex, Integer>{
	public MIndex getFs(int weatherId);
	public MIndex getCt(int weatherId);
	public MIndex getYd(int weatherId);
	public MIndex getXc(int weatherId);
	public MIndex getLs(int weatherId);
}
