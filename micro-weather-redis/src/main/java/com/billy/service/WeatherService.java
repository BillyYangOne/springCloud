package com.billy.service;

import com.billy.vo.WeatherResponse;

public interface WeatherService {

    /**
     * 根据城市Id 获取天气预报数据
     */
    WeatherResponse getDataByCityId(String cityId);

    /**
     * 根据城市名称获取天气数据
     */
    WeatherResponse getDataByCityName(String cityName);
}
