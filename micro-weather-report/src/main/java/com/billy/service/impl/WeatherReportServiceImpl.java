package com.billy.service.impl;

import com.billy.service.WeatherReportService;
import com.billy.service.WeatherService;
import com.billy.vo.Weather;
import com.billy.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private WeatherService weatherService;

    @Override
    public Weather getDataByCityId(String cityId) {

        WeatherResponse dataByCityId = weatherService.getDataByCityId(cityId);
        return dataByCityId.getData();
    }
}
