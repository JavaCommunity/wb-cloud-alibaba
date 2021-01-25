package com.wb.seata.example.controller;

import com.wb.seata.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: OrderController
 * @Package: com.wb.seata.example.controller
 * @Description: the order controller
 * @Author：[bo.wang]
 * @Date: 2021/1/23
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "order/")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/placeOrder/commit")
    public Map<String, Object> placeOrderCommit() {
        orderService.placeOrder("1", "product-1", 1);
        return new HashMap<String, Object>(2) {{
            put("code", "9999");
            put("message", "操作成功！");
        }};
    }

    @RequestMapping("/placeOrder/rollback")
    public Map<String, Object> placeOrderRollback() {
        orderService.placeOrder("1", "product-2", 1);
        return new HashMap<String, Object>(2) {{
            put("code", "9998");
            put("message", "操作失败！");
        }};
    }
}
