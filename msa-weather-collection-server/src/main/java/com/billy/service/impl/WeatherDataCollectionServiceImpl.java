package com.billy.service.impl;

import com.billy.service.WeatherDataCollectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * 天气数据采集服务
 */
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {

    private final static Logger logger = LoggerFactory.getLogger(WeatherDataCollectionServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    // 缓存超时时长
    private final Long TIME_OUT = 1800L;

    private final String WEATHER_API = "http://wthrcdn.etouch.cn/weather_mini";

    @Override
    public void syncDataByCityId(String cityId) {

        logger.info("同步天气数据 --》开始， cityId:" + cityId);
        String uri = WEATHER_API + "?cityKey=" + cityId;
        saveWeatherData(uri);
        logger.info("同步天气数据 --》结束， cityId:" + cityId);
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
}
