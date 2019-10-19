package com.qiao.demo.utils;

 import cn.hutool.json.JSONUtil;
 import com.alibaba.fastjson.JSON;
 import com.google.gson.Gson;
 import com.qiao.demo.config.RegisterProperties;
 import com.qiao.demo.domain.HostPort;
 import com.qiao.demo.exception.PaymentException;
 import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

 import java.io.Serializable;
 import java.util.*;

/**
 * @author: qiaolongjin
 * @date: 2019/9/20
 * @desc:
 */
@Component
public class HttpUtils implements Serializable {
    private static Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private Environment env;


    @Autowired
    RegisterProperties registerProperties;



    /**
     * 获取用户信息
     * @return
     */
    public  Map<String,Object> getWho() {
        final String[] activeProfiles = env.getActiveProfiles();
        if(Arrays.asList(activeProfiles).contains("dev")){
            return new HashMap<String,Object>(){{
                this.put("id","id");
                this.put("username","username");
                this.put("fullname","fullname");
            }};
        }
        final String serviceUrl = this.getResisterServiceUrl(registerProperties.getSsoauthServiceName());
        logger.info("serviceUrl:"+serviceUrl);
        String url=serviceUrl+PaymentConstants.SSO_OAUTH_URL;
        logger.info("url:"+url);
        final String userStr = restTemplate.getForObject(url, String.class);
        logger.info("userStr:"+userStr);
        Gson gson=new Gson();
        final Map map = gson.fromJson(userStr, Map.class);

        logger.info("map:"+ map);
        final Map<String,Object> userMap = (Map<String, Object>) map.get("value");
        logger.info("userMap:"+ userMap);



        return userMap;
    }


    /**
     * 获取register服务地址
     * @param serviceName
     * @return
     */
    public  String getResisterServiceUrl(String serviceName){
        String url= registerProperties.getHostUrl()+serviceName;
        String hostStr=null;
        try{
            hostStr= restTemplate.getForObject(url, String.class);
        }catch (Exception e){
            logger.error("第三方服务请求失败，失败原因",e.getMessage());
            throw new PaymentException("第三方服务请求失败，失败原因"+e.getMessage());
        }

        if(StringUtils.isEmpty(hostStr)){
            logger.error(serviceName+"服务没有实例在运行，请稍后再试");
            throw new PaymentException(serviceName+"服务没有实例在运行，请稍后再试");
        }
        logger.info("hosts::"+hostStr);

        final List<HostPort> hosts = JSON.parseArray(hostStr, HostPort.class);
        if(CollectionUtils.isEmpty(hosts)){
            logger.error(serviceName+"服务没有实例在运行，请稍后再试");
            throw new PaymentException(serviceName+"服务没有实例在运行，请稍后再试");
        }
        logger.info("hosts:",hosts.size(),hosts.toString());
        String serviceUrl="http://";
        HostPort hostPort = hosts.get(0);
        serviceUrl +=hostPort.getHost()+":"+hostPort.getPort();
        return serviceUrl;
    }




    /**
     * 获取办公网的session
     * @return
     */
    public  String getNginxProxySession() {
        String nginxProxySession = null;
        final String[] activeProfiles = env.getActiveProfiles();
        if(Arrays.asList(activeProfiles).contains("dev")){
            final String proxyResult = restTemplate.getForObject(PaymentConstants.PROXY_SESSION_URL, String.class);
            if (StringUtils.isEmpty(proxyResult)) {
                nginxProxySession = JSONUtil.parseObj(proxyResult).get("nginx_proxy_session").toString();
            }
        }
        logger.info("nginxProxySession:: "+nginxProxySession);
        return nginxProxySession;
    }




}
