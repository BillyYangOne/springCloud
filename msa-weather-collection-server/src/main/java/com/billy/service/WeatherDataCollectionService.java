package com.billy.service;

/**
 * 数据采集服务接口
 */
public interface WeatherDataCollectionService {

    /**
     * 根据城市Id同步天气数据
     * @param cityId
     */
    void syncDataByCityId(String cityId);
}
