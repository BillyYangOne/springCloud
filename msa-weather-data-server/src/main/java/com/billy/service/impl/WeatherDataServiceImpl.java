package com.billy.service.impl;

import com.billy.service.WeatherDataService;
import com.billy.vo.WeatherResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private final static Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private final String WEATHER_API = "http://wthrcdn.etouch.cn/weather_mini";

    @Override
    public WeatherResponse getDataByCityId(String cityId) {

        return getWeatherData(WEATHER_API + "?citykey=" + cityId);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        return getWeatherData(WEATHER_API + "?city=" + cityName);
    }

    // 增加redis 缓存处理
    private WeatherResponse getWeatherData(String url) {

        ValueOperations<String, String> ops = this.stringRedisTemplate.opsForValue();

        // 将调用的 uri 作为缓存的 key
        String key = url;
        String strBody = null;

        // 先查询缓存，没有找到，再查询服务
        if (!this.stringRedisTemplate.hasKey(key)) {
            logger.error("不存在 key " + key);
            throw new RuntimeException("没有找到相应的天气信息");
        }else {
            logger.info("找到缓存" +  key);
            strBody = ops.get(key);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        WeatherResponse result = null;
        try {
            result = objectMapper.readValue(strBody, WeatherResponse.class);
        }catch (Exception e){
            logger.error("JSON 序列化异常！", e);
            throw new RuntimeException("天气信息解析失败");
        }
        return result;

    }
}
