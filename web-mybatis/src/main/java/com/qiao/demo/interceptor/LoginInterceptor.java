package com.qiao.demo.interceptor;

import cn.hutool.core.text.StrSpliter;
import com.qiao.demo.config.RegisterProperties;
import com.qiao.demo.enums.HttpStatusEnums;
import com.qiao.demo.exception.PaymentException;
import com.qiao.demo.utils.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author: qiaolongjin
 * @date: 2019/9/20
 * @desc:
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Autowired
    RegisterProperties registerProperties;

    @Autowired
    HttpUtils httpUtils;

    @Autowired
    private Environment env;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        logger.info("preHandle :" +request.getContextPath());
        final String cookie = request.getHeader("Cookie");
        logger.info("cookie:"+cookie);

        /**
         * 校验cookie包含session
         */
        validateCookie(cookie);
        final Map<String, Object> who = httpUtils.getWho();
        if (null==who){
            throw new PaymentException(HttpStatusEnums.NO_AUTH_ACCESS_EXCEPTION);
        }
        logger.info("user info:"+who.get("id"));
        logger.info("user info:"+who);
        request.setAttribute(PaymentConstants.USER_ID,who.get("id"));
        request.setAttribute(PaymentConstants.USER_INFO_MAP,who);
        return true;
    }

    private void validateCookie(String cookie) {
        final String[] activeProfiles = env.getActiveProfiles();
        if(Arrays.asList(activeProfiles).contains("dev")){
            return;
        }
        List<String> cookies = StrSpliter.split(cookie, ';', 0, true, true);
        final boolean isSession = cookies.stream().anyMatch(str -> str.startsWith("session="));
        if(!isSession){
            throw new PaymentException(HttpStatusEnums.NO_AUTH_ACCESS_EXCEPTION);
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }


}
