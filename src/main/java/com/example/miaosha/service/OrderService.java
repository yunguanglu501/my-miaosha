package com.example.miaosha.service;

/**
 * OrderService
 *
 * @author wcy
 */
public interface OrderService {
    int createWrongOrder(int sid);

    int createOptimisticOrder(int sid);

    int createPessimisticOrder(int sid);
}
