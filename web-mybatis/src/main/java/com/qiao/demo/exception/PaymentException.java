package com.qiao.demo.exception;

import com.qiao.demo.enums.HttpStatusEnums;
import lombok.Data;
import lombok.Getter;

/**
 * @author: qiaolongjin
 * @date: 2019/9/11
 * @desc:
 */
@Data
public class PaymentException extends RuntimeException {

    private static final long serialVersionUID = 2359767895161832954L;

    @Getter
    private final HttpStatusEnums resultCode;

    public PaymentException(String message) {
        super(message);
        this.resultCode = HttpStatusEnums.FAILURE;
    }

    public PaymentException(HttpStatusEnums resultCode) {
        super(resultCode.getMessage());
        this.resultCode = resultCode;
    }

    public PaymentException(HttpStatusEnums resultCode, String msg) {
        super(msg);
        this.resultCode = resultCode;
    }

    public PaymentException(HttpStatusEnums resultCode, Throwable cause) {
        super(cause);
        this.resultCode = resultCode;
    }

    public PaymentException(String msg, Throwable cause) {
        super(msg, cause);
        this.resultCode = HttpStatusEnums.FAILURE;
    }


    /**
     * for better performance
     *
     * @return Throwable
     */
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

    public Throwable doFillInStackTrace() {
        return super.fillInStackTrace();
    }


}
