package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudConfigClient8102Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConfigClient8102Application.class, args);
    }

}
