package com.qiao.demo.generator;

import com.baomidou.mybatisplus.annotation.TableField;
<#list table.importPackages as pkg>
import ${pkg};
</#list>
import lombok.Data;
import lombok.Builder;
import java.io.Serializable;
/**
* ${table.comment!}
* @author ${author}
* @since ${date}
*/
@Data
@Builder
<#if table.convert>
@TableName("${table.name}")
</#if>
public class ${entity} extends ${superEntityClass}   implements Serializable  {
<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>
    <#if field.keyFlag>
        <#assign keyPropertyName="${field.propertyName}"/>
    </#if>
    <#if "create_user"==field.name || "create_date"==field.name || "update_user"==field.name || "update_date"==field.name || "enable_flag"=field.name>
    <#else>
    /**
    *   ${field.comment}
    */
    </#if>
    <#if field.keyFlag>
    <#-- 主键 -->
        <#if field.keyIdentityFlag>
        @TableId(value = "${field.name}", type = IdType.AUTO)
        <#elseif idType??>
        @TableId(value = "${field.name}", type = IdType.${idType})
        <#elseif field.convert>
        @TableId("${field.name}")
        </#if>
    <#elseif "create_user"==field.name || "create_date"==field.name || "update_user"==field.name || "update_date"==field.name || "enable_flag"=field.name>
    <#-- 普通字段 -->
    <#elseif field.fill??>
    <#-- -----   存在字段填充设置   ----->
        <#if field.convert>
        @TableField(value = "${field.name}", fill = FieldFill.${field.fill})
        <#else>
        @TableField(fill = FieldFill.${field.fill})
        </#if>
    <#elseif field.convert>
    @TableField("${field.name}")
    <#else>
    @TableField("${field.name}")
    </#if>
<#-- 乐观锁注解 -->
    <#if (versionFieldName!"") == field.name>
    @Version
    </#if>
<#-- 逻辑删除注解 -->
    <#if (logicDeleteFieldName!"") == field.name>
    @TableLogic
    </#if>
    <#if "create_user"==field.name || "create_date"==field.name || "update_user"==field.name || "update_date"==field.name || "enable_flag"=field.name>
    <#else>
     private ${field.propertyType} ${field.propertyName};
    </#if>
</#list>

}
