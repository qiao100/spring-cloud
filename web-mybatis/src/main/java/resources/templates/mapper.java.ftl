package com.qiao.demo.generator;

import com.qiao.demo.generator.${entity};
import ${superMapperClassPackage};
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
*
* ${table.comment!} Mapper 接口
* @author ${author}
* @since ${date}
*/
@Repository
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {
    IPage<${entity}> selectListByPage(IPage page, @Param("ew") QueryWrapper queryWrapper);


    int updateEnableById(@Param("id") Integer id,@Param("updateUser")String userId);


}
