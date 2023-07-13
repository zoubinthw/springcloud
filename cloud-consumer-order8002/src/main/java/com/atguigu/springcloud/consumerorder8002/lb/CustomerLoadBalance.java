package com.atguigu.springcloud.consumerorder8002.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface CustomerLoadBalance {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
