package com.hmall.api.client;

import com.hmall.api.domain.po.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient("order-service")
public interface OrderClient {
    @PutMapping("/orders/update")
    void updateById(Order order);
}
