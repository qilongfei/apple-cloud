package com.cachexic.cloud.feign.order.feign;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.feign.order.entity.Order;
import com.cachexic.cloud.feign.order.entity.query.OrderQuery;
import com.cachexic.cloud.feign.order.feign.fallback.OrderFeignFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author tangmin
 * @version V1.0
 * @Title: OrderFeign.java
 * @Package com.cachexic.cloud.feign.order.feign
 * @Description: feign client
 * @date 2017-09-06 18:13:02
 */
@FeignClient(name = "provider-order", path = "/order", fallbackFactory = OrderFeignFallback.class)
public interface OrderFeign {

    @PostMapping("selectList")
    Result<List<Order>> selectList(@RequestBody OrderQuery orderQuery);

    @GetMapping("getById/{id}")
    Result<Order> getById(@PathVariable("id") Long id);
}
