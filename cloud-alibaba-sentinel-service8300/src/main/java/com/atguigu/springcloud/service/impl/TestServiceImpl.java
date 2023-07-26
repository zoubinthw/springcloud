package com.atguigu.springcloud.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.atguigu.springcloud.service.TestService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TestServiceImpl implements TestService {

    @SentinelResource("common")
    @Override
    public String common() {
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "common";
    }
}
