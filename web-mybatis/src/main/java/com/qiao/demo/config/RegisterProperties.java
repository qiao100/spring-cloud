package com.qiao.demo.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author: qiaolongjin
 * @date: 2019/9/23
 * @desc:  第三方服务名和前缀url配置

 */
@Data
@ConfigurationProperties(prefix = "register.config")
@Component
@AllArgsConstructor
@NoArgsConstructor
public class RegisterProperties implements Serializable {

    /**
     * 基础url
     */
    private String appId;
    /**
     * 基础url
     */
    private String hostUrl;

    /**
     * gbase 服务名
     */
    private String gbaseServiceName;


    /**
     * tril 服务名
     */
    private String trilServiceName;



    /**
     * 其他服务在继续加
     */

    private String ssoauthServiceName;





}
