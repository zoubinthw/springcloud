package com.atguigu.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import com.atguigu.springcloud.domain.Order;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao {
    void create(Order order);

    /**
     * 修改订单金额
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
