package com.qiao.demo.utils;

import com.qiao.demo.enums.HttpStatusEnums;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author: qiaolongjin
 * @date: 2019/9/11
 * @desc:
 */
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public final class BaseResponse<T> implements Serializable {

    private int status;
    private String message;
    //@JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
    private String timestamp;


    public static BaseResponse createResponse(int status, String message) {

        return BaseResponse.builder().status(status).message(message).timestamp(LocalDateTime.now().toString()).build();
    }

    public static BaseResponse createResponse(HttpStatusEnums httpStatusEnums) {

        return BaseResponse.builder().status(httpStatusEnums.getStatus()).message(httpStatusEnums.getMessage()).timestamp(LocalDateTime.now().toString()).build();

    }

    public static BaseResponse createResponse(int status, String message, Object data) {
        return BaseResponse.builder().status(status).message(message).data(data).timestamp(LocalDateTime.now().toString()).build();
    }


    public static BaseResponse createResponse(HttpStatusEnums httpStatusEnums, Object data) {


        return BaseResponse.builder().status(httpStatusEnums.getStatus()).message(httpStatusEnums.getMessage()).data(data).timestamp(LocalDateTime.now().toString()).build();
    }


    public static BaseResponse isSucess(Object data) {
        return BaseResponse.builder().status(HttpStatusEnums.OK.getStatus()).message(HttpStatusEnums.OK.getMessage()).data(data).timestamp(LocalDateTime.now().toString()).build();
    }


}
