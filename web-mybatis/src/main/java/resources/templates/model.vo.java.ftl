package com.qiao.manhour.model.vo;

import lombok.Data;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

/**
* <p>
* ${table.comment!}
* </p>
*
* @author ${author}
* @since ${date}
*/
@Data
public class ${entity}VO extends BaseVO{
<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>

    <#if field.comment!?length gt 0>
    /**
    * ${field.comment}
    */
    </#if>
    @ApiModelProperty(value = "${field.comment}")
    private ${field.propertyType} ${field.propertyName};
</#list>
<#------------  END 字段循环遍历  ---------->
}