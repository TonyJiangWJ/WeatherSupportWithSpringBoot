package com.tony.entity;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tony.commons.entity.BaseEntity;
public class WeatherInfo extends BaseEntity<Integer>  {
    private Integer weatherId;

    private String cityCode;

    private String cityName;

    private static final long serialVersionUID = 1L;

    public Integer getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(Integer weatherId) {
        this.weatherId = weatherId;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", weatherId=").append(weatherId);
        sb.append(", cityCode=").append(cityCode);
        sb.append(", cityName=").append(cityName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}