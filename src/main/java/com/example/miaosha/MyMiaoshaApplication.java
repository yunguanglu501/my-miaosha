package com.example.miaosha;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(basePackages = {"com.example.miaosha.mapper"})
@EnableScheduling
@EnableAsync
public class MyMiaoshaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyMiaoshaApplication.class, args);
    }

}
