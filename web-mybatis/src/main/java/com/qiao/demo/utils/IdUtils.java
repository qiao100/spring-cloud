package com.qiao.demo.utils;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author: qiaolongjin
 * @date: 2019/9/20
 * @desc:  id生成器
 */
@Component
public class IdUtils  {

    /**
     * 获取 templateID
     * @return
     */
    public  static  long  getTemplateId(){
        //参数1为终端ID
        //参数2为数据中心ID
        Snowflake snowflake = IdUtil.createSnowflake(1, 1);
        return snowflake.nextId();
    }





}
