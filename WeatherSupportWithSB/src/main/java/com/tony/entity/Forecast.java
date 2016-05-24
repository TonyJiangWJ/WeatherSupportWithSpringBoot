package com.tony.entity;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tony.commons.entity.BaseEntity;
public class Forecast extends BaseEntity<Integer>  {
    private Integer forecastId;

    private Integer weatherId;

    private String weather1;

    private String weather2;

    private String weather3;

    private String weather4;

    private String weather5;

    private String temp1;

    private String temp2;

    private String temp3;

    private String temp4;

    private String temp5;

    private String fl1;

    private String fl2;

    private String fl3;

    private String fl4;

    private String fl5;

    private String week;

    private String date;

    private static final long serialVersionUID = 1L;

    public Integer getForecastId() {
        return forecastId;
    }

    public void setForecastId(Integer forecastId) {
        this.forecastId = forecastId;
    }

    public Integer getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(Integer weatherId) {
        this.weatherId = weatherId;
    }

    public String getWeather1() {
        return weather1;
    }

    public void setWeather1(String weather1) {
        this.weather1 = weather1 == null ? null : weather1.trim();
    }

    public String getWeather2() {
        return weather2;
    }

    public void setWeather2(String weather2) {
        this.weather2 = weather2 == null ? null : weather2.trim();
    }

    public String getWeather3() {
        return weather3;
    }

    public void setWeather3(String weather3) {
        this.weather3 = weather3 == null ? null : weather3.trim();
    }

    public String getWeather4() {
        return weather4;
    }

    public void setWeather4(String weather4) {
        this.weather4 = weather4 == null ? null : weather4.trim();
    }

    public String getWeather5() {
        return weather5;
    }

    public void setWeather5(String weather5) {
        this.weather5 = weather5 == null ? null : weather5.trim();
    }

    public String getTemp1() {
        return temp1;
    }

    public void setTemp1(String temp1) {
        this.temp1 = temp1 == null ? null : temp1.trim();
    }

    public String getTemp2() {
        return temp2;
    }

    public void setTemp2(String temp2) {
        this.temp2 = temp2 == null ? null : temp2.trim();
    }

    public String getTemp3() {
        return temp3;
    }

    public void setTemp3(String temp3) {
        this.temp3 = temp3 == null ? null : temp3.trim();
    }

    public String getTemp4() {
        return temp4;
    }

    public void setTemp4(String temp4) {
        this.temp4 = temp4 == null ? null : temp4.trim();
    }

    public String getTemp5() {
        return temp5;
    }

    public void setTemp5(String temp5) {
        this.temp5 = temp5 == null ? null : temp5.trim();
    }

    public String getFl1() {
        return fl1;
    }

    public void setFl1(String fl1) {
        this.fl1 = fl1 == null ? null : fl1.trim();
    }

    public String getFl2() {
        return fl2;
    }

    public void setFl2(String fl2) {
        this.fl2 = fl2 == null ? null : fl2.trim();
    }

    public String getFl3() {
        return fl3;
    }

    public void setFl3(String fl3) {
        this.fl3 = fl3 == null ? null : fl3.trim();
    }

    public String getFl4() {
        return fl4;
    }

    public void setFl4(String fl4) {
        this.fl4 = fl4 == null ? null : fl4.trim();
    }

    public String getFl5() {
        return fl5;
    }

    public void setFl5(String fl5) {
        this.fl5 = fl5 == null ? null : fl5.trim();
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week == null ? null : week.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", forecastId=").append(primaryKey);
        sb.append(", weatherId=").append(weatherId);
        sb.append(", weather1=").append(weather1);
        sb.append(", weather2=").append(weather2);
        sb.append(", weather3=").append(weather3);
        sb.append(", weather4=").append(weather4);
        sb.append(", weather5=").append(weather5);
        sb.append(", temp1=").append(temp1);
        sb.append(", temp2=").append(temp2);
        sb.append(", temp3=").append(temp3);
        sb.append(", temp4=").append(temp4);
        sb.append(", temp5=").append(temp5);
        sb.append(", fl1=").append(fl1);
        sb.append(", fl2=").append(fl2);
        sb.append(", fl3=").append(fl3);
        sb.append(", fl4=").append(fl4);
        sb.append(", fl5=").append(fl5);
        sb.append(", week=").append(week);
        sb.append(", date=").append(date);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}