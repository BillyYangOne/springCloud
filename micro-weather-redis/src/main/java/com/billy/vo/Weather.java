package com.billy.vo;

import lombok.Data;

import java.util.List;

/**
 * 天气 vo
 *
 *  city”: 城市名称
 * “aqi”: 空气指数,
 * “wendu”: 实时温度
 * “date”: 日期，包含未来5天
 * “high”:最高温度
 * “low”: 最低温度
 * “fengli”: 风力
 * “fengxiang”: 风向
 * “type”: 天气类型
 *
 */
@Data
public class Weather {

    private Yesterday yesterday;
    private String city;
    private List<Forecast> forecast;
    private String ganmao;
    private String wendu;

}
