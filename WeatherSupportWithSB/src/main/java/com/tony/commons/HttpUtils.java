package com.tony.commons;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;

public class HttpUtils {
	private static String result;
	private final static String url = "http://weatherapi.market.xiaomi.com/wtr-v2/weather?cityId=";
	private static Logger logger = LoggerFactory.getLogger(HttpUtils.class);
	public static String getInfo(String cityCode){
		AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
		logger.info("request URL:{}",url+cityCode);
		Future<Response> f = asyncHttpClient.prepareGet(url+cityCode).execute();
		try {
			Response r = f.get();
			try {
				result = r.getResponseBody("utf-8");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result!=null&&!result.equals("")){
			return result;
		}else
			return null;
		
	}
}
