package com.qiao.demo.interceptor;

import com.qiao.demo.utils.ServletHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author: qiaolongjin
 * @date: 2019/9/23
 * @desc:
 */
@Component
public  class UserAgentInterceptor implements ClientHttpRequestInterceptor {
    private Logger logger = LoggerFactory.getLogger(UserAgentInterceptor.class);


    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        //从请求头里面获取
        HttpServletRequest servletRequest = ServletHelper.getRequest();
        final String cookie = servletRequest.getHeader("Cookie");
        logger.info("cookie:"+cookie);

        //设置cookie
        HttpHeaders headers = request.getHeaders();
        headers.add("Cookie", cookie);

        headers.add("Content-Type","application/json;charset=UTF-8");

        logger.info("headers:"+headers);

        return execution.execute(request, body);
    }


}
