package com.example.miaosha;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.miaosha.entity.Stock;
import com.example.miaosha.mapper.StockMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class MyMiaoshaApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    StockMapper stockMapper;

    @Test
    void test01() {
        Stock stockDO = stockMapper.selectOne(Wrappers.<Stock>lambdaQuery()
                .eq(Stock::getId, 1));
        System.out.println("stockDO = " + stockDO);
    }

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    void test02() {
       stringRedisTemplate.opsForValue().set("k13","v13");
        String k13 = stringRedisTemplate.opsForValue().get("k13");
        System.out.println("k13 = " + k13);
    }


}
