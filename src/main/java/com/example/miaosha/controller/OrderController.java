package com.example.miaosha.controller;

import com.example.miaosha.service.OrderService;
import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * OrderController
 *
 * @author wcy
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    OrderService orderService;

    // 提供一个HTTP接口: 参数为商品的Id
    @PostMapping("/createWrongOrder/{sid}")
    public String createWrongOrder(@PathVariable int sid) {
        log.info("购买物品编号sid=[{}]", sid);
        int id = 0;
        try {
            id = orderService.createWrongOrder(sid);
            log.info("创建订单id: [{}]", id);
        } catch (Exception e) {
            log.error("Exception", e);
        }
        return String.valueOf(id);
    }


    /**
     * 乐观锁更新库存
     *
     * @param sid
     * @return
     */
    @RequestMapping("/createOptimisticOrder/{sid}")
    @ResponseBody
    public String createOptimisticOrder(@PathVariable int sid) {
        int id;
        try {

            id = orderService.createOptimisticOrder(sid);
            log.info("购买成功，剩余库存为: [{}]", id);
        } catch (Exception e) {
            log.error("购买失败：[{}]", e.getMessage());
            return "购买失败，库存不足";
        }
        return String.format("购买成功，剩余库存为：%d", id);
    }

    // 每秒放行10个请求
    RateLimiter rateLimiter = RateLimiter.create(10);

    /**
     * 乐观锁更新库存 + 令牌桶限流
     *
     * @param sid
     * @return
     */
    @RequestMapping("/createOptimisticOrder2/{sid}")
    @ResponseBody
    public String createOptimisticOrder2(@PathVariable int sid) {
        // 阻塞式获取令牌
        // LOGGER.info("等待时间" + rateLimiter.acquire());
        // 非阻塞式获取令牌
        rateLimiter.tryAcquire();
        // if (!rateLimiter.tryAcquire(1000, TimeUnit.MILLISECONDS)) {
        //     log.warn("你被限流了，真不幸，直接返回失败");
        //     return "购买失败，库存不足";
        // }
        int id;
        try {
            id = orderService.createOptimisticOrder(sid);
            log.info("购买成功，剩余库存为: [{}]", id);
        } catch (Exception e) {
            log.error("购买失败：[{}]", e.getMessage());
            return "购买失败，库存不足";
        }
        return String.format("购买成功，剩余库存为：%d", id);
    }


    /**
     * 事务for update更新库存
     * @param sid
     * @return
     */
    @RequestMapping("/createPessimisticOrder/{sid}")
    @ResponseBody
    public String createPessimisticOrder(@PathVariable int sid) {
        int id;
        try {
            id = orderService.createPessimisticOrder(sid);
            log.info("购买成功，剩余库存为: [{}]", id);
        } catch (Exception e) {
            log.error("购买失败：[{}]", e.getMessage());
            return "购买失败，库存不足";
        }
        return String.format("购买成功，剩余库存为：%d", id);
    }
}
