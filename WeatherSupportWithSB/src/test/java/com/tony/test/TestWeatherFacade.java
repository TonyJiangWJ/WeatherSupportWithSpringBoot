package com.tony.test;


import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tony.Application;
import com.tony.commons.DateUtil;
import com.tony.commons.HttpUtils;
import com.tony.entity.Aqi;
import com.tony.entity.Day;
import com.tony.entity.Forecast;
import com.tony.entity.MIndex;
import com.tony.entity.Realtime;
import com.tony.entity.WeatherInfo;
import com.tony.facade.WeatherInfoFacade;
import com.tony.request.WeatherInfoRequest;
import com.tony.service.AqiService;
import com.tony.service.CityInfoService;
import com.tony.service.DayService;
import com.tony.service.ForecastService;
import com.tony.service.IndexService;
import com.tony.service.RealtimeService;
import com.tony.service.WeatherSerivce;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class TestWeatherFacade extends AbstractJUnit4SpringContextTests{
//	@Autowired
//	private WeatherInfoFacade weatherInfoFacade;
	private Logger logger = LoggerFactory.getLogger(TestWeatherFacade.class);
	@Autowired 
	private CityInfoService cityInfoService;
	@Autowired
	private WeatherSerivce weatherService;
	@Autowired 
	private AqiService aqiService;
	@Autowired
	private DayService dayService;
	@Autowired
	private ForecastService forecastService;
	@Autowired
	private IndexService indexService;
	@Autowired
	private RealtimeService realtimeService;
	@Test
	public void test() {
		JSONObject jsonObject = GetFromHttp("101020100");
		System.out.println(jsonObject.toJSONString());
	}

	private JSONObject GetFromHttp(String cityCode){
		String httpResult = HttpUtils.getInfo(cityCode);
		JSONObject resultObj = JSON.parseObject(httpResult);
		Forecast forecast = new Forecast();
		Day today = new Day();
		Day yestoday = new Day();
		Aqi aqi = new Aqi();
		Realtime realtime = new Realtime();
		MIndex fs = new MIndex();
		MIndex ls = new MIndex();
		MIndex xc = new MIndex();
		MIndex yd = new MIndex();
		MIndex ct = new MIndex();
		JSONObject forecastObj = resultObj.getJSONObject("forecast");
		JSONObject todayObj = resultObj.getJSONObject("today");
		JSONObject yestodayObj = resultObj.getJSONObject("yestoday");
		JSONObject realtimeObj = resultObj.getJSONObject("realtime");
		JSONObject aqiObj = resultObj.getJSONObject("aqi");
		JSONArray indexArray = resultObj.getJSONArray("index");
		
		//forecast
		forecast.setDate(forecastObj.getString("date_y"));
		forecast.setFl1(forecastObj.getString("fl1"));
		forecast.setFl2(forecastObj.getString("fl2"));
		forecast.setFl3(forecastObj.getString("fl3"));
		forecast.setFl4(forecastObj.getString("fl4"));
		forecast.setFl5(forecastObj.getString("fl5"));
		forecast.setTemp1(forecastObj.getString("temp1"));
		forecast.setTemp2(forecastObj.getString("temp2"));
		forecast.setTemp3(forecastObj.getString("temp3"));
		forecast.setTemp4(forecastObj.getString("temp4"));
		forecast.setTemp5(forecastObj.getString("temp5"));
		forecast.setWeather1(forecastObj.getString("weather1"));
		forecast.setWeather2(forecastObj.getString("weather2"));
		forecast.setWeather3(forecastObj.getString("weather3"));
		forecast.setWeather4(forecastObj.getString("weather4"));
		forecast.setWeather5(forecastObj.getString("weather5"));
		forecast.setWeek(forecastObj.getString("week"));
		//today
		today.setDate(DateUtil.GetDateFromString(todayObj.getString("date")));
		today.setDayType(1);
		today.setTempMax(todayObj.getInteger("tempMax"));
		today.setTempMin(todayObj.getInteger("tempMin"));
		today.setWeatherEnd(todayObj.getString("weatherEnd"));
		today.setWeatherStart(todayObj.getString("weatherStart"));
		today.setWindDirEnd(todayObj.getString("windDirectionEnd"));
		today.setWindDirStart(todayObj.getString("windDirectionStart"));
		today.setWindMax(todayObj.getInteger("windMax"));
		today.setWindMin(todayObj.getInteger("windMin"));
		//yestoday
		yestoday.setDate(DateUtil.GetDateFromString(yestodayObj.getString("date")));
		yestoday.setDayType(0);
		yestoday.setTempMax(yestodayObj.getInteger("tempMax"));
		yestoday.setTempMin(yestodayObj.getInteger("tempMin"));
		yestoday.setWeatherEnd(yestodayObj.getString("weatherEnd"));
		yestoday.setWeatherStart(yestodayObj.getString("weatherStart"));
		yestoday.setWindDirEnd(yestodayObj.getString("windDirectionEnd"));
		yestoday.setWindDirStart(yestodayObj.getString("windDirectionStart"));
		yestoday.setWindMax(yestodayObj.getInteger("windMax"));
		yestoday.setWindMin(yestodayObj.getInteger("windMin"));
		//aqi
		aqi.setAqi(aqiObj.getInteger("aqi"));
		aqi.setNo2(aqiObj.getInteger("no2"));
		aqi.setPm10(aqiObj.getInteger("pm10"));
		aqi.setPm25(aqiObj.getInteger("pm25"));
		logger.info("pub_time:{}",aqiObj.getString("pub_time"));
		logger.info("cast time from pub_time:{}",DateUtil.GetDateFromString(aqiObj.getString("pub_time")));
		aqi.setPubTime(DateUtil.GetDateFromString(aqiObj.getString("pub_time")));
		aqi.setSo2(aqiObj.getInteger("so2"));
		aqi.setSrc(aqiObj.getString("src"));
		//realtime
		realtime.setSd(realtimeObj.getString("SD"));
		realtime.setTemp(realtimeObj.getInteger("temp"));
		realtime.setTime(realtimeObj.getString("time"));
		realtime.setWd(realtimeObj.getString("WD"));
		realtime.setWeather(realtimeObj.getString("weather"));
		realtime.setWs(realtimeObj.getString("WS"));
		//index
		WeatherInfo weatherInfo = new WeatherInfo();
		weatherInfo.setCityCode(cityCode);
		weatherInfo.setCityName(cityInfoService.findByPrimaryKey(cityCode).getTownName());
		weatherService.save(weatherInfo);
		logger.info("weatherInfo after insert/save:{}",JSON.toJSONString(weatherInfo));
		WeatherInfo weatherInfo2 = weatherService.findByPrimaryKey(19);
		logger.info("weatherInfo after find:{}",JSON.toJSONString(weatherInfo));
		logger.info("weatherInfo2 after find:{}",JSON.toJSONString(weatherInfo2));
		int weatherId = weatherInfo.getWeatherId();
		
		for(int i=0;i<indexArray.size();i++){
			switch (indexArray.getJSONObject(i).getString("code")) {
			case "fs":
				fs.setCode("fs");
				fs.setDetails(indexArray.getJSONObject(i).getString("details"));
				fs.setIndex(indexArray.getJSONObject(i).getString("index"));
				fs.setIndexName(indexArray.getJSONObject(i).getString("name"));
				fs.setWeatherId(weatherId);
				indexService.save(fs);
				break;
			case "ls":
				ls.setCode("ls");
				ls.setDetails(indexArray.getJSONObject(i).getString("details"));
				ls.setIndex(indexArray.getJSONObject(i).getString("index"));
				ls.setIndexName(indexArray.getJSONObject(i).getString("name"));
				ls.setWeatherId(weatherId);
				indexService.save(ls);
				break;
			case "ct":
				ct.setCode("ct");
				ct.setDetails(indexArray.getJSONObject(i).getString("details"));
				ct.setIndex(indexArray.getJSONObject(i).getString("index"));
				ct.setIndexName(indexArray.getJSONObject(i).getString("name"));
				ct.setWeatherId(weatherId);
				indexService.save(ct);
				break;
			case "yd":
				yd.setCode("yd");
				yd.setDetails(indexArray.getJSONObject(i).getString("details"));
				yd.setIndex(indexArray.getJSONObject(i).getString("index"));
				yd.setIndexName(indexArray.getJSONObject(i).getString("name"));
				yd.setWeatherId(weatherId);
				indexService.save(yd);
				break;
			case "xc":
				xc.setCode("xc");
				xc.setDetails(indexArray.getJSONObject(i).getString("details"));
				xc.setIndex(indexArray.getJSONObject(i).getString("index"));
				xc.setIndexName(indexArray.getJSONObject(i).getString("name"));
				xc.setWeatherId(weatherId);
				indexService.save(xc);
				break;
			default:
				break;
			}
		}
		forecast.setWeatherId(weatherId);
		today.setWeatherId(weatherId);
		yestoday.setWeatherId(weatherId);
		aqi.setWeatherId(weatherId);
		realtime.setWeatherId(weatherId);
		forecastService.save(forecast);
		dayService.save(today);
		dayService.save(yestoday);
		aqiService.save(aqi);
		logger.info("aqi before insert:{} pubtime:{}",JSON.toJSONString(aqi),aqi.getPubTime());
		realtimeService.save(realtime);
		logger.info("forecast:{} today:{} yestoday:{} aqi:{} realtime:{}",JSON.toJSONString(forecast),JSON.toJSONString(today),JSON.toJSONString(yestoday),JSON.toJSONString(aqi),JSON.toJSONString(realtime));
		JSONObject weatherObj = new JSONObject();
		Aqi out = aqiService.findByWeatherId(32);
		logger.info("aqi after insert:{}",JSON.toJSONString(out));
		weatherObj.put("city", weatherInfo.getCityName());
		weatherObj.put("realtime", JSON.toJSON(realtime));
		logger.info("realtime:{}",JSON.toJSONString(realtime));
		
		weatherObj.put("forecast", JSON.toJSON(forecast));
		logger.info("forecast:{}",JSON.toJSONString(forecast));
		
		weatherObj.put("today", JSON.toJSON(today));
		logger.info("today:{}",JSON.toJSONString(today));
		
		weatherObj.put("yestoday", JSON.toJSON(yestoday));
		logger.info("yestoday:{}",JSON.toJSONString(yestoday));
		
		weatherObj.put("aqi", JSON.toJSON(aqi));
		logger.info("aqi:{}",JSON.toJSONString(aqi));
		
		logger.info("weatherObj before jsonArray:{}",weatherObj.toJSONString());
		JSONArray indexArray2 = new JSONArray();
		indexArray2.add(JSON.toJSON(fs));
		indexArray2.add(JSON.toJSON(ls));
		indexArray2.add(JSON.toJSON(ct));
		indexArray2.add(JSON.toJSON(yd));
		indexArray2.add(JSON.toJSON(xc));
		logger.info("indexArray:{}",indexArray2.toJSONString());
		weatherObj.put("index", indexArray2);
		logger.info("weatherObj:{}",weatherObj.toJSONString());
		return weatherObj;
		
	}
}
