package com.billy.common;

import lombok.Getter;
import org.springframework.beans.BeanUtils;

/**
 * @author Billy
 * @description: 结果类枚举
 * @date 2020/5/11 16:28
 */
@Getter
public enum ResultCodeEnum {

    SUCCESS(true, 200, "成功"),
    ERROR(false, 500, "未知错误"),
    PARAM_ERROR(false, 501, "未知错误"),
    NULL_POINT_ERROR(false, 503, "空指针异常");

    // 响应是否成功
    private Boolean success;
    // 响应状态码
    private Integer code;
    // 响应消息
    private String message;

    ResultCodeEnum(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }


}
