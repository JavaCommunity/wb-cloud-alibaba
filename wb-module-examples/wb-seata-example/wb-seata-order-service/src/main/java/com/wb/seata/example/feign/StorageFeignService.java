package com.wb.seata.example.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @ClassName: StorageFeignService
 * @Package: com.wb.seata.example.feign
 * @Description: the storage feign service
 * @Author：[bo.wang]
 * @Date: 2021/1/23
 * @Version: 1.0
 */
@FeignClient(name = "wb-seata-storage-service")
public interface StorageFeignService {

    @GetMapping("storage/deduct")
    Map<String, Object> deduct(@RequestParam("commodityCode") String commodityCode, @RequestParam("count") Integer count);
}
