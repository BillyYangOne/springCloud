package com.billy.service;

import com.billy.vo.City;

import java.util.List;

/**
 * @desciption 城市数据接口
 */
public interface CityDataService {


    /**
     * 获取城市列表
     * @return
     * @throws Exception
     */
    List<City> listCity() throws Exception;
}
