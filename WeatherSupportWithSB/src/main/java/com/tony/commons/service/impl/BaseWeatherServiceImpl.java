package com.tony.commons.service.impl;

import java.io.Serializable;

import org.springframework.util.Assert;

import com.alibaba.fastjson.JSON;
import com.tony.commons.dao.BaseWeatherDao;
import com.tony.commons.entity.BaseEntity;
import com.tony.commons.service.BaseWeatherService;

public abstract class BaseWeatherServiceImpl<T extends BaseEntity<E>,E extends Serializable> extends BaseServiceImpl<E, T> implements BaseWeatherService<T, E>{

	@Override
	public T findByWeatherId(int weatherId) {
		// TODO Auto-generated method stub
		//System.out.println("inside findByWeatherId");
		T test = getDao().selectByWeatherId(weatherId);
		if(test!=null)
			;//System.out.println("test:"+JSON.toJSONString(test));
		else
			;//System.out.println("null test");
		return getDao().selectByWeatherId(weatherId);
	}

	@Override
	protected abstract BaseWeatherDao<T, E> getDao();
	
	@Override 
	public int save(T record){
		Assert.notNull(record);
		if(record.getPrimaryKey()!=null){
			return getDao().updateByPrimaryKey(record);
		}else {
			if(find(record)!=null)
			{
				//System.out.println("existed "+JSON.toJSONString(record)+", record:"+JSON.toJSONString(find(record)));
				record.setPrimaryKey(find(record).getPrimaryKey());
				record.setWeatherId(find(record).getWeatherId());
				//System.out.println(JSON.toJSONString("inside save haha:"+record+" primaryKey:"+record.getPrimaryKey()));
				return getDao().updateByPrimaryKey(record);	
			}
			else{
				//System.out.println("not exist "+JSON.toJSONString(record)+"not exist");
				return getDao().insert(record);
			}
		}
	}
	
}
