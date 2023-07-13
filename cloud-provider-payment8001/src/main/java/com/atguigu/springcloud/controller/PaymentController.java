package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService; //

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("-------插入的结果: " + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功, serverPort: " + serverPort + "," + result);
        } else {
            return new CommonResult(404, "插入数据失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("-------查询结果: " + payment);
        if (payment != null) {
            return new CommonResult(200, "查询数据成功, serverPort: " + serverPort + "," + payment);
        } else {
            return new CommonResult(404, "没有对应记录，查询ID: " + id, null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discoveryServer() {
        List<String> services = discoveryClient.getServices(); // 这个注册中心都有哪些服务
        for (String service : services) {
            log.info("-------- service: " + service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE"); // 哪些实例保存了这个微服务
        for (ServiceInstance instance : instances) {
            log.info("******* instance: " + instance.getInstanceId() +
                    ", host name: " + instance.getHost() +
                    ", port" + instance.getPort() +
                    ", uri: " + instance.getUri());
        }

        return discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return this.serverPort;
    }
}
