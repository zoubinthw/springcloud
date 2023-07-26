package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class FlowLimitController {
    @Resource
    private TestService testService;
    @GetMapping("/testA")
    public String testA() {
        log.info("lalala");
//        TimeUnit.MILLISECONDS.sleep(30000);
//        return testService.common();
        return "testA";
    }

    @GetMapping("/testB")
    public String testB()
    {
//        return testService.common();
        return "testB";
    }
}
