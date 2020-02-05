package com.billy.service;

import com.billy.vo.WeatherResponse;

/**
 * @description 天气预报服务接口层
 * @author BillyYang
 */
public interface WeatherService {

    /**
     * 根据城市Id 获取天气预报数据
     */
    WeatherResponse getDataByCityId(String cityId);

    /**
     * 根据城市名称获取天气数据
     */
    WeatherResponse getDataByCityName(String cityName);

    /**
     * 根据城市id 同步天气预报数据
     * @param cityId
     */
    void syncDataByCityId(String cityId);


}
