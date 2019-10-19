package com.qiao.demo.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author: qiaolongjin
 * @date: 2019/9/18
 * @desc:
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyMetaObjectHandler.class);



    @Override
    public void insertFill(MetaObject metaObject) {
        LOGGER.info("start insert fill ....");
        this.setInsertFieldValByName("createDate", LocalDateTime.now(), metaObject);//版本号3.0.6以及之前的版本

        //this.setInsertFieldValByName("createUser", userHandler.getCurrentUserId(), metaObject);//版本号3.0.6以及之前的版本
     }



    @Override
    public void updateFill(MetaObject metabject) {
        LOGGER.info("start update fill ....");
        this.setUpdateFieldValByName("updateDate", LocalDateTime.now(), metabject);

        //this.setUpdateFieldValByName("updateUser", userHandler.getCurrentUserId(), metabject);
     }



}