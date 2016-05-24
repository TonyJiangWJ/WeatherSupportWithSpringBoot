package com.tony.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.tony.commons.dao.BaseWeatherDao;
import com.tony.commons.service.impl.BaseWeatherServiceImpl;
import com.tony.dao.MIndexMapper;
import com.tony.entity.MIndex;
import com.tony.service.IndexService;
@Transactional
@Service("indexService")
public class IndexServiceImpl extends BaseWeatherServiceImpl<MIndex, Integer> implements IndexService{

	@Autowired
	private MIndexMapper indexDao;

	@Override
	protected BaseWeatherDao<MIndex, Integer> getDao() {
		// TODO Auto-generated method stub
		return indexDao;
	}

	private MIndex fs;
	private MIndex ct;
	private MIndex yd;
	private MIndex xc;
	private MIndex ls;
	private Logger logger = LoggerFactory.getLogger(IndexServiceImpl.class);
	private List<MIndex> indexs;
	
	private void GetIndexs(int weatherId){
		if(indexs==null||indexs.size()==0){
			indexs = indexDao.selectListByWeatherId(weatherId);
			for(int i=0;i<indexs.size();i++){
				logger.info("line 41 index at {} is:{}",i,JSON.toJSONString(indexs.get(i)));
				switch(indexs.get(i).getCode()){
					case "fs":fs=indexs.get(i);
						break;
					case "ct":ct=indexs.get(i);
						break;
					case "yd":yd=indexs.get(i);
						break;
					case "xc":xc=indexs.get(i);
						break;
					case "ls":ls=indexs.get(i);
						break;
				}
			}
		}
	}
	public MIndex getFs(int weatherId) {
		GetIndexs(weatherId);
		return fs;
	}
	public MIndex getCt(int weatherId) {
		GetIndexs(weatherId);
		return ct;
	}
	public MIndex getYd(int weatherId) {
		GetIndexs(weatherId);
		return yd;
	}
	public MIndex getXc(int weatherId) {
		GetIndexs(weatherId);
		return xc;
	}
	public MIndex getLs(int weatherId) {
		GetIndexs(weatherId);
		return ls;
	}
	
	

}
