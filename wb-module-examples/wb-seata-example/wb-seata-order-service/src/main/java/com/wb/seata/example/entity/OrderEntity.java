package com.wb.seata.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName: OrderEntity
 * @Package: com.wb.seata.example.entity
 * @Description: the order entity
 * @Author：[bo.wang]
 * @Date: 2021/1/23
 * @Version: 1.0
 */
@TableName("order_tbl")
public class OrderEntity implements Serializable {

    //  the id
    @TableId(type = IdType.AUTO)
    private Integer id;

    //  the user id
    private String userId;

    //  the commodity code
    private String commodityCode;

    //  the count
    private Integer count;

    //  the money
    private BigDecimal money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
