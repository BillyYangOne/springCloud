package com.billy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FrameworkCommonApplication {

    public static void main(String[] args) {
        System.out.println("hello world!");
        SpringApplication.run(FrameworkCommonApplication.class, args);
    }

}
