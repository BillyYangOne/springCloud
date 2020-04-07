package com.billy.controller;

import com.billy.service.WeatherDataService;
import com.billy.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 天气数据查询 API 服务
 */
@RestController
@RequestMapping("weather")
public class WeatherController {

    @Autowired
    private WeatherDataService weatherService;

    @GetMapping("/cityId/{cityId}")
    public WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId) {
        return weatherService.getDataByCityId(cityId);
    }

    @GetMapping("/cityName/{cityName}")
    public WeatherResponse getDataByCityName(@PathVariable("cityName") String cityName) {
        return weatherService.getDataByCityName(cityName);
    }


}
