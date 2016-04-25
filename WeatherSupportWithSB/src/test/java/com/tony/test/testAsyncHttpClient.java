package com.tony.test;

import org.junit.Test;

import com.tony.commons.HttpUtils;

public class testAsyncHttpClient {
	
	@Test
	public void test() {
		System.out.println("result:"+HttpUtils.getInfo("101010100"));
	}

}
