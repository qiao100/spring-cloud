package com.qiao.demo.generator;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import  com.qiao.demo.generator.${entity};

import  com.qiao.demo.generator.${table.serviceName};
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "api/${entity}")
@Api(value = "api/${entity}", tags = "${table.comment!}")
public class ${entity}Controller  {

    @Autowired
    private ${table.serviceName} ${entity}Service;

    @ApiOperation(value = "保存${table.comment!}(新增/修改)")
    @PostMapping(value = "/save")
    public Integer save(@ApiParam(name = "对象") @Valid @RequestBody ${entity} domain) {
        Integer result;
        result = ${entity}Service.insert(domain);

        return result;
    }


    @ApiOperation(value = "删除")
    @PostMapping(value = "/delete/{id}")
    public Integer delete(@PathVariable Integer id,HttpServletRequest request) {
        String userId = (String) request.getAttribute("userId");

        return ${entity}Service.updateEnableById(id,userId);
    }




}
