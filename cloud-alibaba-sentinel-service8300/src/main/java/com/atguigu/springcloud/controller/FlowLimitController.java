package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

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

    @GetMapping("/testD")
    public String testD()
    {
        //暂停几秒钟线程
//        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
//        log.info("testD 测试RT");

        // 异常比例&数目测试
        log.info("testD 测试异常占比");
        int age = 10/0;
        return "------testD";
    }

    @GetMapping("/testE")
    public String testE()
    {
        // 异常数目测试
        log.info("testD 测试异常数目");
        int age = 10/0;
        return "------testD";
    }
}
