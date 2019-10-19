package com.qiao.demo.exception;


import org.apache.commons.lang3.StringUtils;
import com.qiao.demo.utils.BaseResponse;
import com.qiao.demo.enums.HttpStatusEnums;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.io.IOException;
import java.io.Serializable;

/**
 * @author: qiaolongjin
 * @date: 2019/9/11
 * @desc:
 */
@RestControllerAdvice
public final class ExceptionAdviceHandler implements Serializable {
    private ObjectError objectError;

    /**
     * 未知异常
     */
    @ExceptionHandler(value = Exception.class)
    public BaseResponse unKnowExceptionHandler(Exception e) {
        e.printStackTrace();
        StackTraceElement[] elements = e.getStackTrace();
        String message = "";
        if (elements.length > 0) {
            StackTraceElement element = elements[0];

            message = StringUtils.join("控制器", element.getClassName(), ".", element.getMethodName(), "类的第", element.getLineNumber(), "行发生", e.toString(), "异常");
        }
        if (StringUtils.isEmpty(message)) {
            message = e.toString();
        }
        return BaseResponse.createResponse(HttpStatusEnums.UNKNOW_EXCEPTION.getStatus(), message);
    }

    /**
     * 自定义运行时异常
     */
    @ExceptionHandler(value = PaymentException.class)
    public BaseResponse demoExceptionHandler(PaymentException e) {
        e.printStackTrace();
        StackTraceElement[] elements = e.getStackTrace();
        String message = StringUtils.EMPTY;
        if (elements.length > 0) {
            StackTraceElement element = elements[0];
            message = StringUtils.join(e.toString());
        }
        if (StringUtils.isBlank(message)) {
            message = e.getMessage();
        }
        return BaseResponse.createResponse(e.getResultCode(), message);
    }

    /**
     * 运行时异常
     */
    @ExceptionHandler(value = RuntimeException.class)
    public BaseResponse runtimeExceptionHandler(RuntimeException e) {
        e.printStackTrace();
        StackTraceElement[] elements = e.getStackTrace();
        String message = StringUtils.EMPTY;
        if (elements.length > 0) {
            StackTraceElement element = elements[0];
            message = StringUtils.join("控制器", element.getClassName(), ".", element.getMethodName(), "类的第", element.getLineNumber(), "行发生", e.toString(), "异常");
        }
        if (StringUtils.isBlank(message)) {
            message = e.toString();
        }
        return BaseResponse.createResponse(HttpStatusEnums.RUNTIME_EXCEPTION.getStatus(), message);
    }

    /**
     * 空指针异常
     */
    @ExceptionHandler(NullPointerException.class)
    public BaseResponse nullPointerExceptionHandler(NullPointerException e) {
        e.printStackTrace();
        StackTraceElement[] elements = e.getStackTrace();
        String message = StringUtils.EMPTY;
        if (elements.length > 0) {
            StackTraceElement element = elements[0];
            message = StringUtils.join("控制器", element.getClassName(), ".", element.getMethodName(), "类的第", element.getLineNumber(), "行发生", e.toString(), "异常");
        }
        if (StringUtils.isBlank(message)) {
            message = e.toString();
        }
        return BaseResponse.createResponse(HttpStatusEnums.NULL_POINTER_EXCEPTION.getStatus(), message);
    }

    /**
     * 类型转换异常
     */
    @ExceptionHandler(ClassCastException.class)
    public BaseResponse classCastExceptionHandler(ClassCastException e) {
        e.printStackTrace();
        StackTraceElement[] elements = e.getStackTrace();
        String message = StringUtils.EMPTY;
        if (elements.length > 0) {
            StackTraceElement element = elements[0];
            message = StringUtils.join("控制器", element.getClassName(), ".", element.getMethodName(), "类的第", element.getLineNumber(), "行发生", e.toString(), "异常");
        }
        if (StringUtils.isBlank(message)) {
            message = e.toString();
        }
        return BaseResponse.createResponse(HttpStatusEnums.CLASS_CAST_EXCEPTION.getStatus(), message);
    }

    /**
     * IO异常
     */
    @ExceptionHandler(IOException.class)
    public BaseResponse iOExceptionHandler(IOException e) {
        e.printStackTrace();
        StackTraceElement[] elements = e.getStackTrace();
        String message = StringUtils.EMPTY;
        if (elements.length > 0) {
            StackTraceElement element = elements[0];
            message = StringUtils.join("控制器", element.getClassName(), ".", element.getMethodName(), "类的第", element.getLineNumber(), "行发生", e.toString(), "异常");
        }
        if (StringUtils.isBlank(message)) {
            message = e.toString();
        }
        return BaseResponse.createResponse(HttpStatusEnums.IO_EXCEPTION.getStatus(), message);
    }

    /**
     * 数组越界异常
     */
    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseStatus(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseResponse indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException e) {
        e.printStackTrace();
        StackTraceElement[] elements = e.getStackTrace();
        String message = StringUtils.EMPTY;
        if (elements.length > 0) {
            StackTraceElement element = elements[0];
            message = StringUtils.join("控制器", element.getClassName(), ".", element.getMethodName(), "类的第", element.getLineNumber(), "行发生", e.toString(), "异常");
        }
        if (StringUtils.isBlank(message)) {
            message = e.toString();
        }
        return BaseResponse.createResponse(HttpStatusEnums.INDEX_OUTOF_BOUNDS_EXCEPTION.getStatus(), message);
    }

    /**
     * 参数类型不匹配
     */
    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public BaseResponse requestTypeMismatch(MethodArgumentTypeMismatchException e) {
        return BaseResponse.createResponse(HttpStatusEnums.METHOD_ARGUMENT_TYPE_MISMATCH_EXCEPTIION.getStatus(), "参数类型不匹配，参数" + e.getName() + "类型必须为" + e.getRequiredType());
    }

    /**
     * 缺少参数
     */
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public BaseResponse requestMissingServletRequest(MissingServletRequestParameterException e) {
        return BaseResponse.createResponse(HttpStatusEnums.MISSING_SERVLET_REQUEST_PARAMETER_EXCEPTION.getStatus(), "缺少必要参数，参数名称为" + e.getParameterName());
    }

    /**
     * 请求method不匹配
     */
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public BaseResponse requestMissingServletRequest(HttpRequestMethodNotSupportedException e) {
        return BaseResponse.createResponse(HttpStatusEnums.HTTP_REQUEST_METHOD_NOT_SUPPORTED_EXCEPTION.getStatus(), "不支持" + e.getMethod() + "方法，支持" + StringUtils.join(e.getSupportedMethods(), ",") + "类型");
    }

    /**
     * 控制器方法中@RequestBody类型参数数据类型转换异常
     */
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public BaseResponse httpMessageNotReadableException(HttpMessageNotReadableException e, WebRequest wq) {
        e.printStackTrace();
        Throwable throwable = e.getRootCause();
        return BaseResponse.createResponse(HttpStatusEnums.METHOD_ARGUMENT_TYPE_MISMATCH_EXCEPTIION.getStatus(), throwable.getMessage());
    }

    /**
     * 控制器方法参数异常
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public BaseResponse methodArgumentNotValidException(MethodArgumentNotValidException e) {
        e.printStackTrace();
        BindingResult bindingResult = e.getBindingResult();
        FieldError fieldError = bindingResult.getFieldError();
        String message = StringUtils.join(fieldError.getDefaultMessage());
        return BaseResponse.createResponse(HttpStatusEnums.MISSING_SERVLET_REQUEST_PARAMETER_EXCEPTION.getStatus(), message);
    }

}

