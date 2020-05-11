package com.billy.controller;

import com.billy.common.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author Billy
 * @description: 测试控制层
 * @date 2020/5/11 16:50
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("list")
    public Object listUsers() {

        logger.info("打印日志");
        logger.error("错误日志");
        logger.debug("debug日志");
        ArrayList<Object> objects = null;
        System.out.println(objects.get(1));
        return R.ok().data(null).message("用户列表");
    }


}
