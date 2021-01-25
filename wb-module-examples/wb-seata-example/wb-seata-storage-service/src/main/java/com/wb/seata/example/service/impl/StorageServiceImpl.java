package com.wb.seata.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wb.seata.example.entity.StorageEntity;
import com.wb.seata.example.repository.StorageRepository;
import com.wb.seata.example.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: StorageServiceImpl
 * @Package: com.wb.seata.example.service.impl
 * @Description: the storage service impl
 * @Author：[bo.wang]
 * @Date: 2021/1/25
 * @Version: 1.0
 */
@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageRepository storageRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deduct(String commodityCode, int count) {
        if (commodityCode.equals("product-2")) {
            throw new RuntimeException("异常:模拟业务异常:Storage branch exception");
        }

        QueryWrapper<StorageEntity> wrapper = new QueryWrapper<>();
        StorageEntity storageEntity = new StorageEntity();
        storageEntity.setCommodityCode(commodityCode);
        wrapper.setEntity(storageEntity);
        StorageEntity resultStorageEntity = storageRepository.selectOne(wrapper);
        resultStorageEntity.setCount(resultStorageEntity.getCount() - count);
        storageRepository.updateById(resultStorageEntity);
    }
}
