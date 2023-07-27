package com.atguigu.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

public class CustomerBlockHandler {
    public static CommonResult handlerException1(BlockException blockException) {
        return new CommonResult(444,
                "---1---: 按客户定义, global handler exception: " + blockException.getMessage());
    }

    public static CommonResult handlerException2(BlockException blockException) {
        return new CommonResult(444,
                "---2---: 按客户定义, global handler exception: " + blockException.getMessage());
    }
}
