package com.tony.commons.service.impl;

import java.io.Serializable;

import org.springframework.util.Assert;

import com.tony.commons.dao.BaseDao;
import com.tony.commons.entity.BaseEntity;
import com.tony.commons.service.BaseService;

public abstract class BaseServiceImpl<E extends Serializable,T extends BaseEntity<E>> implements BaseService<T, E>{
	
	protected abstract BaseDao<T,  E> getDao();
	
	public T find(T record){
		Assert.notNull(record);
		return getDao().find(record);
	}
	
	public T findByPrimaryKey(E id){
		return getDao().selectByPrimaryKey(id);
	}
	
	public int save(T t){
		Assert.notNull(t);
		if(t.getPrimaryKey()!=null){
			return getDao().updateByPrimaryKey(t);
		}else if(find(t)!=null){
			T temp = find(t);
			t.setPrimaryKey(temp.getPrimaryKey());
			return getDao().updateByPrimaryKey(t);
		}else{
			return getDao().insert(t);
		}
	}
	
	public int deleteByPrimaryKey(E id){
		Assert.notNull(id);
		return getDao().deleteByPrimaryKey(id);
	}
	
	public int updateByPrimaryKey(T record){
		Assert.notNull(record);
		return getDao().updateByPrimaryKey(record);
	}
	
	public int updateByPrimaryKeySelective(T record){
		Assert.notNull(record);
		return getDao().updateByPrimaryKeySelective(record);
	}
	
	
	
}
