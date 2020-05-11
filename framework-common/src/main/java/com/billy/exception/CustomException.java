package com.billy.exception;

import com.billy.common.ResultCodeEnum;
import lombok.Data;

/**
 * @author Billy
 * @description: 自定义异常处理类
 * @date 2020/5/11 18:24
 */
@Data
public class CustomException extends RuntimeException {

    private Integer code;

    public CustomException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public CustomException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "CustomException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}
