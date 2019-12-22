package com.billy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @since 1.0.0 2019年12月22日 18点57分
 * @author Billy
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello() {

        return "Hello world, welcome!";
    }

}
