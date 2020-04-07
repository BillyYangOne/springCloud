package com.billy.service;

import com.billy.vo.WeatherResponse;

/**
 * @description 天气数据API服务
 * @author BillyYang
 */
public interface WeatherDataService {

    /**
     * 根据城市Id 获取天气预报数据
     */
    WeatherResponse getDataByCityId(String cityId);

    /**
     * 根据城市名称获取天气数据
     */
    WeatherResponse getDataByCityName(String cityName);

}
