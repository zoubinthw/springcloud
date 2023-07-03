package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CloudEurekaServer8004Application {

	public static void main(String[] args) {
		SpringApplication.run(CloudEurekaServer8004Application.class, args);
	}

}
