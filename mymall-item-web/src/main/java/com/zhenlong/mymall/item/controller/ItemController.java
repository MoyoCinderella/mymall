package com.zhenlong.mymall.item.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @date 2019-08-25 16:30
 */
@RestController
public class ItemController {
    @GetMapping("/index")
    public String test(){

        return "hello world!";
    }
}
