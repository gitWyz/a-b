package com.wyz.user.bean.enums;

/**
 * 结果信息枚举类
 *
 * @author wangyizhong
 * @version 1.0
 * @date 2020-11-06 11:37
 **/
public enum ResultCodeEnum {
    SUCCESS(20000,"成功"),
    CUSTOMER_ERROR(20001,"自定义错误"),
    UNKNOWN_ERROR(20002,"未知错误"),
    PARAM_ERROR(20003,"参数错误"),
    NULL_POINTER(20004,"空指针异常"),
    NO_FILE_CONTENT( 30001, "文件内容为空"),
    GET_FILE_CONTENT( 30002, "获取文件失败"),
    SAVE_FILE( 30003, "保存文件失败"),
    SAVE_MYSQL_FAILED( 40001, "保存mysql数据库异常"),
    UPDATE_MYSQL_FAILED( 40002, "更新mysql数据库异常"),
    MAIL_SEND_FAILED( 50001, "邮件发送失败"),
    CAPTCHA_SEND_FAILED( 50002, "验证码发送失败"),
    NOT_EXIST_PHONE(50003,"您操作的账号信息不存在，请联系您的管理员"),
    CAPTCHA_VERIFY_ERROR(50004,"您输入的验证码有误，请重新输入"),
    NOT_EXIST_STAFF(50005,"员工信息不存在，请联系您的管理员"),
    EXIST_MOBILE(50006,"该账号已经存在"),
    TWO_PASSWORD_ENTRIES_ARE_INCONSISTENT(50007,"两次密码输入不一致"),
    MODIFY_USER_EXCLUDE_MOBILE(50008,"不允许修改登录账号信息"),
    MODIFY_USER_EXISTS(50009,"用户已存在，请更换手机号"),
    CHECK_PWD_DIFF(50010,"您输入的用户名和密码不匹配"),
    NOT_VALID_ACCOUNT(50011,"该账号已停用"),
    OLD_PWD_ERROR(60004, "旧密码填写错误，请更正"),
    COOKIE_ILLEGAL(304, "cookie is illegal"),
    COOKIE_PROCESS(305, "cookie process exception"),
    ;

    private final Integer code;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    /**
     * 响应信息
     */
    private final String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
