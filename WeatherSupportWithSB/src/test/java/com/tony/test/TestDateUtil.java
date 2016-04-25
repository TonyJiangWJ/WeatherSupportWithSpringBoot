package com.tony.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tony.commons.DateUtil;

public class TestDateUtil {

	private final String date1="2016-04-25 07:00";
	private final String date2="2016-04-25 07:00:00";
	private final String date3="2016-04-25";
	private Logger logger = LoggerFactory.getLogger(TestDateUtil.class);
	@Test
	public void test() {
		logger.info("date1:{}",DateUtil.GetDateFromString(date1));
		logger.info("date2:{}",DateUtil.GetDateFromString(date2));
		logger.info("date3:{}",DateUtil.GetDateFromString(date3));
	}

}
