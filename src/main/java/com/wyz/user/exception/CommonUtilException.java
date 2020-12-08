package com.wyz.user.exception;

/**
 * javadoc 编解码 加解密算法异常
 *
 * @author wyz
 * @date 2020/11/6 14:23
 * @version 1.0.0
 */
public class CommonUtilException extends RuntimeException{
    public CommonUtilException() {
    }

    public CommonUtilException(String message) {
        super(message);
    }

    public CommonUtilException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommonUtilException(Throwable cause) {
        super(cause);
    }

    public CommonUtilException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
