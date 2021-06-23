package com.wb.common.utils.entity;

import com.wb.common.base.entity.BaseEntity;
import com.wb.common.config.DelFlagEnum;
import com.wb.common.utils.date.DateUtils;
import com.wb.common.utils.id.UUIDUtils;
import com.wb.common.wrapper.SysUserWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @ClassName: EntityUtils
 * @Package: com.wb.common.utils.entity
 * @Description: the entity utils
 * @Author：[bo.wang]
 * @Date: 2021/2/18
 * @Version: 1.0
 */
public class EntityUtils {

    /**
     * save base entity with the base entity and sys user wrapper
     *
     * @param baseEntity  the base entity
     * @param userWrapper the user wrapper
     */
    public static void save(BaseEntity baseEntity, SysUserWrapper userWrapper) {
        if (!(ObjectUtils.isEmpty(baseEntity) || ObjectUtils.isEmpty(userWrapper))) {
            if (StringUtils.isEmpty(baseEntity.getId())) {
                baseEntity.setId(UUIDUtils.generateId());
                baseEntity.setCreateUser(userWrapper.getName());
                baseEntity.setCreateUserId(userWrapper.getId());
                baseEntity.setCreateTime(DateUtils.formatDateTime(new Date()));
                baseEntity.setDelFlag(DelFlagEnum.UN_DEL.getCode());
                baseEntity.setCreateOrg(userWrapper.getCreateOrg());
                baseEntity.setCreateOrgId(userWrapper.getCreateOrgId());
                baseEntity.setUpdateTime(null);
                baseEntity.setUpdateUser(null);
                baseEntity.setUpdateUserId(null);
            } else {
                baseEntity.setUpdateUserId(userWrapper.getId());
                baseEntity.setUpdateUser(userWrapper.getName());
                baseEntity.setUpdateTime(DateUtils.formatDateTime(new Date()));
            }
        }

        BaseEntity entity = new BaseEntity();
        entity.setDataYear("123");

        BaseEntity entity1 = new BaseEntity();
        entity.setDataYear("123123");
        entity.setDelFlag("1");
        BeanUtils.copyProperties(entity,entity1);
    }
}
