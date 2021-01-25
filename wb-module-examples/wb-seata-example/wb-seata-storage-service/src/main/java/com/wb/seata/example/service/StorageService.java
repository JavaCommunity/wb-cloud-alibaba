package com.wb.seata.example.service;

/**
 * @ClassName: StorageService
 * @Package: com.wb.seata.example.service
 * @Description: the storage service
 * @Author：[bo.wang]
 * @Date: 2021/1/25
 * @Version: 1.0
 */
public interface StorageService {

    void deduct(String commodityCode, int count);
}
