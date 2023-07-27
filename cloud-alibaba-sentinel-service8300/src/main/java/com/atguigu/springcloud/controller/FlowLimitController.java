package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "dealTestHotKey") // 这里的value可以是任何字符串，只要名称唯一即可
    public String testHotKey(
            @RequestParam(value = "p1", required = false) String p1,
            @RequestParam(value = "p2", required = false) String p2
    )
    {
        return "------testHotKey p1: " + p1 + ", p2: " + p2;
    }
    public String dealTestHotKey(String p1, String p2, BlockException exception) {
        return "---------dealTestHotKey, ~~~~~~~~~";
    }
}
