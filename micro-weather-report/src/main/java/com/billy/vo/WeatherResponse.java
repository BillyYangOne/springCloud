package com.billy.vo;

import lombok.Data;

/**
 * 天气数据
 */
@Data
public class WeatherResponse {

    private Weather data;
    private String status;
    private String desc;
}
