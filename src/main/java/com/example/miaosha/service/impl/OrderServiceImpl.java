package com.example.miaosha.service.impl;

import com.example.miaosha.entity.Stock;
import com.example.miaosha.service.OrderService;
import com.example.miaosha.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * OrderServiceImpl
 *
 * @author wcy
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    StockService stockService;
    @Override
    public int createWrongOrder(int sid) {
        //校验库存
        Stock stock = checkStock(sid);
        //扣库存
        saleStock(stock);
        //创建订单
        int id = createOrder(stock);
        return id;
    }

    private Stock checkStock(int sid) {
        Stock stock = stockService.getStockById(sid);
        if (stock.getSale().equals(stock.getCount())) {
            throw new RuntimeException("库存不足");
        }
        return stock;
    }

    private int saleStock(Stock stock) {
        stock.setSale(stock.getSale() + 1);
        return stockService.updateStockById(stock);
    }

    private int createOrder(Stock stock) {
        // StockOrder order = new StockOrder();
        // order.setSid(stock.getId());
        // order.setName(stock.getName());
        // int id = orderMapper.insertSelective(order);
        return 1;
    }
}
