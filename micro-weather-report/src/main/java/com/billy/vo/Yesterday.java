package com.billy.vo;

import lombok.Data;

@Data
public class Yesterday {

    // 日期
    private String date;
    // 高温
    private String high;
    // 风向
    private String fx;
    // 低温
    private String low;
    // 风力
    private String fl;
    // 类型
    private String type;
}
