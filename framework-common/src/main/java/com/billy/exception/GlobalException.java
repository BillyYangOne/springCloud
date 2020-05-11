package com.billy.exception;

import com.billy.common.R;
import com.billy.common.ResultCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Billy
 * @description: 统一异常处理类
 * @date 2020/5/11 17:24
 */
@ControllerAdvice
public class GlobalException {

    private Logger logger = LoggerFactory.getLogger(GlobalException.class);

    /**
     * 通用异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e) {
        logger.error(ExceptionUtil.getMessage(e));
        return R.error();
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public R error(NullPointerException e) {
        logger.error(ExceptionUtil.getMessage(e));
        return R.setResult(ResultCodeEnum.NULL_POINT_ERROR);
    }

    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public R error(CustomException e) {
        logger.error(ExceptionUtil.getMessage(e));
        return R.error().message(e.getMessage()).code(e.getCode());
    }
}
