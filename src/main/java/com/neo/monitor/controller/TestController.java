package com.neo.monitor.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author blue-light
 * Date: 2022-08-17
 * Description:
 */
@Slf4j
@RestController
public class TestController {
    @GetMapping("")
    public String test() {
        log.info("移动电话={},邮箱={}", "13752983019", "703347383@qq.com");
        return "success";
    }
}
