package com.wb.seata.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * @ClassName: StorageEntity
 * @Package: com.wb.seata.example.entity
 * @Description: the storage entity
 * @Author：[bo.wang]
 * @Date: 2021/1/25
 * @Version: 1.0
 */
@TableName("storage_tbl")
public class StorageEntity implements Serializable {

    private static final long serialVersionUID = 2953989977910374871L;

    //  the id
    @TableId(type = IdType.AUTO)
    private Long id;

    //  the commodity code
    private String commodityCode;

    //  the count
    private Long count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
