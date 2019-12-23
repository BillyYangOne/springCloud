package com.billy.service;

import com.billy.vo.WeatherResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private RestTemplate restTemplate;

    private final String WEATHER_API = "http://wthrcdn.etouch.cn/weather_mini";

    @Override
    public WeatherResponse getDataByCityId(String cityId) {

        return getWeatherData(WEATHER_API + "?citykey=" + cityId);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        return getWeatherData(WEATHER_API + "?city=" + cityName);
    }

    private WeatherResponse getWeatherData(String url) {

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        WeatherResponse result = null;
        try {
            if (responseEntity.getStatusCodeValue() == 200) {
                String strBody = responseEntity.getBody();
                ObjectMapper objectMapper = new ObjectMapper();
                result = objectMapper.readValue(strBody, WeatherResponse.class);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;

    }
}
