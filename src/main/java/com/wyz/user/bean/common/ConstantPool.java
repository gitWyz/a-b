package com.wyz.user.bean.common;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

/**
 * javadoc 本common包常量属性配置
 *
 * @author wyz
 * @date 2020/11/6 10:56
 * @version 1.0.0
 */
public class ConstantPool {

    private ConstantPool(){

    }

    public static final ZoneId DEFAULT_ZONE_ID = ZoneId.of("Asia/Shanghai");

    public static final String DEFAULT_DATE_FORMATTER_PATTERN = "yyyy-MM-dd";
    public static final DateTimeFormatter DEFAULT_DATE_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMATTER_PATTERN);

    public static final String DEFAULT_TIME_FORMATTER_PATTERN = "HH:mm:ss";
    public static final DateTimeFormatter DEFAULT_TIME_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_TIME_FORMATTER_PATTERN);

    public static final String DEFAULT_DATE_TIME_FORMATTER_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final DateTimeFormatter DEFAULT_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMATTER_PATTERN);

    public static final int DEFAULT_OK_CODE = 0;
    public static final String DEFAULT_OK_MESSAGE = "success";

    public static final int DEFAULT_ERROR_CODE = -1;
    public static final String DEFAULT_ERROR_MESSAGE = "error";


    public static final String EMPTY_STRING = "";

    public static final Pattern PHONE_PATTERN = Pattern.compile("^[1]\\d{10}$");
    public static final int DEFAULT_PHONE_NUMBER_LENGTH = 11;
    /**
     * 随机密码的默认长度
     * @author wyz
     * @date 13:29 2020/11/6
     **/
    public static final int DEFAULT_RANDOM_PWD_LENGTH = 6;
    /**
     * 验证码的默认长度
     * @author wyz
     * @date 11:39 2020/11/6
     **/
    public static final int DEFAULT_RANDOM_CAPTCHA_LENGTH = 6;
    /**
     * 验证码的有效时间
     * @author wyz
     * @date 11:39 2020/11/6
     **/
    public static final int CAPTCHA_TIMETOLIVE = 60;

    /**
     * 1.必须包含@
     * 2.允许开头及结尾有空白
     *  '@'  之前:
     * 3.第一个非空白字符（有效字符）,只能是字母、数字、下划线
     * 4. '@' 前的部分不能出现连续的..,但是允许.-或者
     * 5.从第二个字符开始，除了字母、数字、下划线，还支持中划线-和英文句号
     *  '@' 之后:
     * 6. '@' 后面第一个字符是字母、数字
     * 7.最后一个.后面只能接字母
     * 8.邮箱以.+ 至少一个字母结尾, ex: .com, .cn
     * 9. '@' 后面，从第二个字符开始允许.或者-,但是不允许..,.-,-.的出现..和-需要和字母数字下划线间隔出现
     **/
    public static final Pattern EMAIL_PATTERN = Pattern.compile("^\\s*\\w+(?:\\.?[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$");


    public static final int MINUTES = 24 * 60;

    /**
     * 通用token key
     **/
    public static final String SHADOW_TOKEN = "SHADOW_TOKEN";

    public static final String ID = "ID";

}
