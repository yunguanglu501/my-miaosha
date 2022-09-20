package com.example.miaosha.controller;

import com.example.miaosha.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    //提供一个HTTP接口: 参数为商品的Id
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
}
