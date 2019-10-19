package com.qiao.demo.generator;


import  com.qiao.demo.generator.${entity};

/**
*
* ${table.comment!} 服务类
*
* @author ${author}
* @since ${date}
*/

public interface ${table.serviceName} {

    int insert(${entity} bo);

    int updateEnableById(int id,String userId);


}


