package com.tony.commons.service;

import java.io.Serializable;

public interface BaseService <T extends Serializable,E extends Serializable>{
	
	public T find(T record);
	
	public T findByPrimaryKey(E id);
	
	public int save(T t);
	
	public int deleteByPrimaryKey(E id);
	
	public int updateByPrimaryKey(T record);
	
	public int updateByPrimaryKeySelective(T record);
}
