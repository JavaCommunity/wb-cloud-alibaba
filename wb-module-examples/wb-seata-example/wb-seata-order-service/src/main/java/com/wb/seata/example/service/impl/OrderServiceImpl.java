package com.wb.seata.example.service.impl;

import com.wb.seata.example.entity.OrderEntity;
import com.wb.seata.example.repository.OrderRepository;
import com.wb.seata.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @ClassName: OrderServiceImpl
 * @Package: com.wb.seata.example.service.impl
 * @Description: the order service impl
 * @Author：[bo.wang]
 * @Date: 2021/1/23
 * @Version: 1.0
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

//    @Autowired
//    private StorageFeignService storageFeignService;

    @Override
    public void placeOrder(String userId, String commodityCode, Integer count) {
        BigDecimal orderMoney = new BigDecimal(count).multiply(new BigDecimal(5));
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setUserId(userId);
        orderEntity.setCommodityCode(commodityCode);
        orderEntity.setCount(count);
        orderEntity.setMoney(orderMoney);
        orderRepository.insert(orderEntity);
        // storageFeignService.deduct(commodityCode, count);
    }
}
