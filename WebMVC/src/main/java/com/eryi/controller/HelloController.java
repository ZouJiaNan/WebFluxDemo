package com.eryi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: ZouJiaNan
 * @date: 2022/3/21 19:18
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "welcome to reactive world";
    }
}
