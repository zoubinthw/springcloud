package com.atguigu.springcloud.consumerorder8002.lb.impl;

import com.atguigu.springcloud.consumerorder8002.lb.CustomerLoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
public class MyLB implements CustomerLoadBalance {
    private AtomicInteger nextServerCyclicCounter = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;
        do {
           current = this.nextServerCyclicCounter.get();
           next = current >= 2147483640 ? 0 : current + 1;
        } while (!this.nextServerCyclicCounter.compareAndSet(current, next));
        log.info("The next index of instance is: " + next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();

        return serviceInstances.get(index);
    }
}
