package com.billy.service.impl;

import com.billy.service.WeatherReportService;
import com.billy.vo.Weather;
import org.springframework.stereotype.Service;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Override
    public Weather getDataByCityId(String cityId) {

        // TODO 修改为通过天气数据API微服务提供数据

        return null;
    }
}
