package com.esmile.common.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.esmile.common.filter.CurrentUserFilter;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Autowired
    private CurrentUserFilter userFilter;

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert field ....");
        this.strictInsertFill(metaObject, "createBy", () -> userFilter.getUserId(), String.class);
        this.strictInsertFill(metaObject, "createDate", LocalDateTime::now, LocalDateTime.class);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        this.strictUpdateFill(metaObject, "updateBy", () -> userFilter.getUserId(), String.class);
        this.strictUpdateFill(metaObject, "updateDate", LocalDateTime::now, LocalDateTime.class); // 起始版本 3.3.3(推荐)
    }
}
