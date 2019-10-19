package com.qiao.nacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * @author: qiaolongjin
 * @date: 2019/8/5
 * @desc:
 */
@RestController
public class GetConfigController {

    @Value("${config}")
    private String config;

    @RequestMapping(value = "/echo/config", method = RequestMethod.GET)
    public String getConfig() {
        return config;
    }

}
