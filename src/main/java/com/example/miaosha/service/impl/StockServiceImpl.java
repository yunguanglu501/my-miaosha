package com.example.miaosha.service.impl;

import com.example.miaosha.entity.Stock;
import com.example.miaosha.mapper.StockMapper;
import com.example.miaosha.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * StockServiceImpl
 *
 * @author wcy
 */
@Service
@Slf4j
public class StockServiceImpl implements StockService {

    @Autowired
    StockMapper stockMapper;
    @Override
    public Stock getStockById(int sid) {
        return stockMapper.selectById(sid);
    }

    @Override
    public int updateStockById(Stock stock) {
        return 0;
    }
}
