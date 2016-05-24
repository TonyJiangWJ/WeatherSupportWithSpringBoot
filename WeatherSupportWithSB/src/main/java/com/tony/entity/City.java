package com.tony.entity;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tony.commons.entity.BaseEntity;
public class City extends BaseEntity<String> {
    private String cityCode;

    private String enName;

    private String townName;

    private String cityName;

    private String provinceName;

    private static final long serialVersionUID = 1L;

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName == null ? null : enName.trim();
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName == null ? null : townName.trim();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cityCode=").append(primaryKey);
        sb.append(", enName=").append(enName);
        sb.append(", townName=").append(townName);
        sb.append(", cityName=").append(cityName);
        sb.append(", provinceName=").append(provinceName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}