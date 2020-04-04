package com.billy.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @since 1.0.0 2020年3月29日 22点52分
 * @author Billy
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello() {

        return "Hello world, welcome!";
    }

    @RequestMapping("/")
    public String hello() {
        return "hello, billy";
    }

    @RequestMapping("/index")
    public ModelAndView getPage(Model model) {

        return new ModelAndView("webSocket", "socketModel", model);
    }

}
