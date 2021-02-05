package com.wb.feign.consume.example.feign;

import com.wb.common.result.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @ClassName: UserFeignService
 * @Package: com.wb.feign.consume.example.feign
 * @Description: the user feign service
 * @Author：[bo.wang]
 * @Date: 2021/2/5
 * @Version: 1.0
 */
@FeignClient(name = "wb-feign-provider-example")
public interface UserFeignService {

    @GetMapping(value = "user/findByUserId")
    R<Map<String, Object>> findByUserId(@RequestParam(value = "userId") String userId);
}
