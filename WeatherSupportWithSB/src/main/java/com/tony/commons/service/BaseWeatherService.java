package com.tony.commons.service;

import java.io.Serializable;

public interface BaseWeatherService<T extends Serializable,E extends Serializable> extends BaseService<T, E>{
	public T findByWeatherId(int weatherId);
	
}
