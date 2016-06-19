package com.tony.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tony.commons.DateUtil;
import com.tony.commons.dao.BaseDao;
import com.tony.commons.service.impl.BaseServiceImpl;
import com.tony.dao.UserMapper;
import com.tony.entity.User;
import com.tony.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl extends BaseServiceImpl<String, User> implements UserService{

	@Autowired
	private UserMapper userDao;
	@Override
	protected BaseDao<User, String> getDao() {
		// TODO Auto-generated method stub
		return userDao;
	}
	@Override
	public int save(User t) {
		// TODO Auto-generated method stub
		t.setCreatedTime(DateUtil.GetDateString());
		return super.save(t);
	}

	
}
