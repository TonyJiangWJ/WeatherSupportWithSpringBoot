package com.tony.entity;

import java.io.Serializable;
import java.util.Date;

import com.tony.commons.entity.BaseEntity;

public class Day extends BaseEntity<Integer>  {
    private Integer dayId;

    private Integer dayType;

    private Integer weatherId;

    private Date date;

    private Integer tempMax;

    private Integer tempMin;

    private String weatherStart;

    private String weatherEnd;

    private String windDirStart;

    private String windDirEnd;

    private Integer windMax;

    private Integer windMin;

    private static final long serialVersionUID = 1L;

    public Integer getDayId() {
        return dayId;
    }

    public void setDayId(Integer dayId) {
        this.dayId = dayId;
    }

    public Integer getDayType() {
        return dayType;
    }

    public void setDayType(Integer dayType) {
        this.dayType = dayType;
    }

    public Integer getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(Integer weatherId) {
        this.weatherId = weatherId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getTempMax() {
        return tempMax;
    }

    public void setTempMax(Integer tempMax) {
        this.tempMax = tempMax;
    }

    public Integer getTempMin() {
        return tempMin;
    }

    public void setTempMin(Integer tempMin) {
        this.tempMin = tempMin;
    }

    public String getWeatherStart() {
        return weatherStart;
    }

    public void setWeatherStart(String weatherStart) {
        this.weatherStart = weatherStart == null ? null : weatherStart.trim();
    }

    public String getWeatherEnd() {
        return weatherEnd;
    }

    public void setWeatherEnd(String weatherEnd) {
        this.weatherEnd = weatherEnd == null ? null : weatherEnd.trim();
    }

    public String getWindDirStart() {
        return windDirStart;
    }

    public void setWindDirStart(String windDirStart) {
        this.windDirStart = windDirStart == null ? null : windDirStart.trim();
    }

    public String getWindDirEnd() {
        return windDirEnd;
    }

    public void setWindDirEnd(String windDirEnd) {
        this.windDirEnd = windDirEnd == null ? null : windDirEnd.trim();
    }

    public Integer getWindMax() {
        return windMax;
    }

    public void setWindMax(Integer windMax) {
        this.windMax = windMax;
    }

    public Integer getWindMin() {
        return windMin;
    }

    public void setWindMin(Integer windMin) {
        this.windMin = windMin;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dayId=").append(primaryKey);
        sb.append(", dayType=").append(dayType);
        sb.append(", weatherId=").append(weatherId);
        sb.append(", date=").append(date);
        sb.append(", tempMax=").append(tempMax);
        sb.append(", tempMin=").append(tempMin);
        sb.append(", weatherStart=").append(weatherStart);
        sb.append(", weatherEnd=").append(weatherEnd);
        sb.append(", windDirStart=").append(windDirStart);
        sb.append(", windDirEnd=").append(windDirEnd);
        sb.append(", windMax=").append(windMax);
        sb.append(", windMin=").append(windMin);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}