package com.billy.service.impl;

import com.billy.service.WeatherService;
import com.billy.vo.WeatherResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final static Logger logger = LoggerFactory.getLogger(WeatherServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    // 缓存超时时长
    private final Long TIME_OUT = 1800L;

    private final String WEATHER_API = "http://wthrcdn.etouch.cn/weather_mini";

    @Override
    public WeatherResponse getDataByCityId(String cityId) {

        return getWeatherData(WEATHER_API + "?citykey=" + cityId);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        return getWeatherData(WEATHER_API + "?city=" + cityName);
    }

    @Override
    public void syncDataByCityId(String cityId) {

        this.saveWeatherData(WEATHER_API + "?citykey=" + cityId);
    }

    /**
     * 保存天气预报数据
     * @param uri
     */
    private void saveWeatherData(String uri) {

        ValueOperations<String, String> ops = this.stringRedisTemplate.opsForValue();

        String strBody = null;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
        if (responseEntity.getStatusCodeValue() == 200) {
            strBody = responseEntity.getBody();
        }
        ops.set(uri, strBody, TIME_OUT, TimeUnit.SECONDS);
    }

    // 增加redis 缓存处理
    private WeatherResponse getWeatherData(String url) {

        ValueOperations<String, String> ops = this.stringRedisTemplate.opsForValue();

        // 将调用的 uri 作为缓存的 key
        String key = url;
        String strBody = null;

        // 先查询缓存，没有找到，再查询服务
        if (!this.stringRedisTemplate.hasKey(key)) {
            logger.info("未找到缓存");
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
            if (responseEntity.getStatusCodeValue() == 200) {
                strBody = responseEntity.getBody();
            }
            ops.set(key, strBody, TIME_OUT, TimeUnit.SECONDS);
        }else {
            logger.info("找到缓存" +  key);
            strBody = ops.get(key);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        WeatherResponse result = null;
        try {
            result = objectMapper.readValue(strBody, WeatherResponse.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;

    }
}
