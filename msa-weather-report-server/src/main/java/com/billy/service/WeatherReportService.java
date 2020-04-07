package com.billy.service;

import com.billy.vo.Weather;

/**
 * @description 天气预报服务接口层
 * @author BillyYang
 */
public interface WeatherReportService {

    Weather getDataByCityId(String cityId);
}
