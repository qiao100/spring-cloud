<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >

<!-- 指明当前xml对应的Mapper -->
<mapper namespace="com.qiao.demo.generator.${table.mapperName}">

    <select id="selectListByPage" resultType="com.qiao.demo.generator.${entity}">
        SELECT * FROM ${table.name}
    </select>
    <update id="updateEnableById">
        update ${table.name} set
        enable_flag=0,
        update_user= <#noparse>#{userId},
        update_date= NOW()
        where id= #{id} and enable_flag=1
    </update>




</mapper>
