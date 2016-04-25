package com.tony.commons.dao;

import java.io.Serializable;

public interface BaseWeatherDao<T extends Serializable,E extends Serializable> extends BaseDao<T, E>{
	public T selectByWeatherId(int weatherId);
}
