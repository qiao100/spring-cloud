package com.qiao.demo.config;

 import com.qiao.demo.utils.BaseResponse;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
 import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


/**
 * @author: qiaolongjin
 * @date: 2019/9/11
 * @desc:
 */
@EnableWebMvc
@Configuration
public class BaseResponseConfig extends WebMvcAutoConfiguration {

    @RestControllerAdvice("com.qiao.demo.controller")
    static class CommonResultResponseAdvice implements ResponseBodyAdvice<Object> {
        @Override
        public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
            return true;
        }

        @Override
        public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
            if (body instanceof BaseResponse) {
                return body;
            }
            return BaseResponse.isSucess(body);
        }
    }




}


