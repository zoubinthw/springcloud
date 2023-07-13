package com.atguigu.springcloud.myrlue;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule() {
        return new RandomRule(); // 定义为使用随机方式的负载均衡
    }
}
