package com.wyz.user.exception;

import com.wyz.user.bean.enums.ResultCodeEnum;

/**
 * 自定义异常
 *
 * @author wangyizhong
 * @version 1.0
 * @date 2020-11-06 11:33
 **/
public class CustomException extends RuntimeException{
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public CustomException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public CustomException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "CMSException{" + "code=" + code + ", message=" + this.getMessage() + '}';
    }
}
