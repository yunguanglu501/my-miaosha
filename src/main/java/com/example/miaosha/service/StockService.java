package com.example.miaosha.service;

import com.example.miaosha.entity.Stock;

/**
 * StockService
 *
 * @author wcy
 */
public interface StockService {

    Stock getStockById(int sid);

    int updateStockById(Stock stock);
}
