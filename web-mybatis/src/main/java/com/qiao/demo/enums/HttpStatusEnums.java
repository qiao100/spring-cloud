package com.qiao.demo.enums;

/**
 * @author: qiaolongjin
 * @date: 2019/9/11
 * @desc:
 */
public enum HttpStatusEnums {
    OK(200, "SUCCESS"),
    UNKNOW_EXCEPTION(2000, "未知异常"),
    RUNTIME_EXCEPTION(2002, "运行时异常"),
    NULL_POINTER_EXCEPTION(2003, "空指针异常"),
    CLASS_CAST_EXCEPTION(2004, "类型转换异常"),
    IO_EXCEPTION(2005, "IO异常"),
    INDEX_OUTOF_BOUNDS_EXCEPTION(2006, "数组越界异常"),
    METHOD_ARGUMENT_TYPE_MISMATCH_EXCEPTIION(2007, "参数类型不匹配"),
    MISSING_SERVLET_REQUEST_PARAMETER_EXCEPTION(2008, "缺少参数"),
    HTTP_REQUEST_METHOD_NOT_SUPPORTED_EXCEPTION(2009, "不支持的method类型"),

    FAILURE(500, "业务异常"),

    //--------------------OAuth2认证异常------------------
    AUTHENTICATION_EXCEPTION(3000, "登录异常，请检查登录信息..."),
    ACCESS_DENIDED_EXCEPTION(3000, "访问资源受限"),
    PASSWORD_EXCEPTION(3002, "密码异常"),
    NO_AUTH_ACCESS_EXCEPTION(401, "无权限访问系统");


    private final int status;
    private final String message;

    private HttpStatusEnums(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
