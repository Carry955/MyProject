package com.carry.myproject.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class FieldMetaObjectHandler implements MetaObjectHandler {
    private final static String CREATE_TIME = "createTime";
    private final static String UPDATE_TIME = "updateTime";
    @Override
    public void insertFill(MetaObject metaObject) {
        strictInsertFill(metaObject, CREATE_TIME, Date.class, new Date());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        strictUpdateFill(metaObject, UPDATE_TIME, Date.class, new Date());
    }
}
