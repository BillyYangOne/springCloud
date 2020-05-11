package com.billy.common;

import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @author Billy
 * @description: 统一结果类
 * @date 2020/5/11 16:36
 */
@Data
public class R {

    private Boolean success;
    private Integer Code;
    private String message;
    private Object data;

    public R() {
    }

    public static R ok() {
        R r = new R();
        r.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
        r.setCode(ResultCodeEnum.SUCCESS.getCode());
        r.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return r;
    }

    public static R error() {
        R r = new R();
        r.setSuccess(ResultCodeEnum.ERROR.getSuccess());
        r.setCode(ResultCodeEnum.ERROR.getCode());
        r.setMessage(ResultCodeEnum.ERROR.getMessage());
        return r;
    }

    public R success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

    public R code(Integer code) {
        this.setCode(code);
        return this;
    }

    public R message(String message) {
        this.setMessage(message);
        return this;
    }

    public R data(Object data) {
        this.setData(data);
        return this;
    }

    public static R setResult(ResultCodeEnum result) {
        R r = new R();
        BeanUtils.copyProperties(result, r);
        return r;
    }


}
