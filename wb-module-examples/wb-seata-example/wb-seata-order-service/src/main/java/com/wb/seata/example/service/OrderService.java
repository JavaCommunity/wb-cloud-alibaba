package com.wb.seata.example.service;

/**
 * @ClassName: OrderService
 * @Package: com.wb.seata.example.service
 * @Description: the order service
 * @Author：[bo.wang]
 * @Date: 2021/1/23
 * @Version: 1.0
 */
public interface OrderService {

    void placeOrder(String userId, String commodityCode, Integer count);
}
