package com.qiao.demo.generator;

import com.qiao.demo.generator.${entity};
import com.qiao.demo.generator.${entity}Mapper;

import com.qiao.demo.generator.${table.serviceName};

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
* <p>
    * ${table.comment!} 服务实现类
    * </p>
*
* @author ${author}
* @since ${date}
*/
@Service
public class ${table.serviceImplName} implements ${table.serviceName} {
    @Autowired
    ${entity}Mapper ${entity}Mapper;

    @Override
    public int insert(${entity} entity) {
        return ${entity}Mapper.insert(entity);
    }


    @Override
    public int updateEnableById(int id,String userId) {
    return ${entity}Mapper.updateEnableById(id,userId);
    }




}
