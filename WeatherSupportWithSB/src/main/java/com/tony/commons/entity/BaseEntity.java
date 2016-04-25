package com.tony.commons.entity;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity<T extends Serializable> implements  Serializable {

	private static final long serialVersionUID = 1L;

	protected T primaryKey;
	
	protected Integer weatherId;
	
	public Integer getWeatherId() {
		return weatherId;
	}

	public void setWeatherId(Integer weatherId) {
		this.weatherId = weatherId;
	}

	public T getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(T primaryKey) {
		this.primaryKey = primaryKey;
	}

}
