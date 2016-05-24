package com.tony.entity;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tony.commons.entity.BaseEntity;
public class Realtime extends BaseEntity<Integer>  {
    private Integer realtimeId;

    private Integer weatherId;

    private String sd;

    private String wd;

    private String ws;

    private Integer temp;

    private String time;

    private String weather;

    private static final long serialVersionUID = 1L;

    public Integer getRealtimeId() {
        return realtimeId;
    }

    public void setRealtimeId(Integer realtimeId) {
        this.realtimeId = realtimeId;
    }

    public Integer getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(Integer weatherId) {
        this.weatherId = weatherId;
    }

    public String getSd() {
        return sd;
    }

    public void setSd(String sd) {
        this.sd = sd == null ? null : sd.trim();
    }

    public String getWd() {
        return wd;
    }

    public void setWd(String wd) {
        this.wd = wd == null ? null : wd.trim();
    }

    public String getWs() {
        return ws;
    }

    public void setWs(String ws) {
        this.ws = ws == null ? null : ws.trim();
    }

    public Integer getTemp() {
        return temp;
    }

    public void setTemp(Integer temp) {
        this.temp = temp;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather == null ? null : weather.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", realtimeId=").append(primaryKey);
        sb.append(", weatherId=").append(weatherId);
        sb.append(", sd=").append(sd);
        sb.append(", wd=").append(wd);
        sb.append(", ws=").append(ws);
        sb.append(", temp=").append(temp);
        sb.append(", time=").append(time);
        sb.append(", weather=").append(weather);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}