package com.wyz.user.util;


import com.wyz.user.exception.CommonUtilException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Objects;

/**
 * javadoc 加解密, 编解码相关
 *
 * @author wyz
 * @date 2020/11/6 13:51
 * @version 1.0.0
 */
public class CodecUtil {
    private CodecUtil(){

    }
    /**
     * Used to build output as Hex
     */
    private static final char[] DIGITS_LOWER = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
            'e', 'f' };

    /**
     * Used to build output as Hex
     */
    private static final char[] DIGITS_UPPER = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D',
            'E', 'F' };
    /**
     * javadoc hashCodec
     * @apiNote hash摘要三巨头: MD5 SHA1 SHA256
     *
     * @param data 摘要源
     * @param algorithm 算法名
     * @param upper 摘要结果是否大写
     * @return java.lang.String
     * @author wyz
     * @date 2020/11/6 13:57
     * @modified none
     */
    private static String hashCodec(String data, String algorithm, boolean upper) throws NoSuchAlgorithmException {
        if(Objects.isNull(data) || Objects.isNull(algorithm)){
            return null;
        }
        final MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.update(data.getBytes(StandardCharsets.UTF_8));
        final byte[] result = digest.digest();
        return String.valueOf(hex(result, upper ? DIGITS_UPPER : DIGITS_LOWER));
    }

    /**
     * javadoc hex
     * @apiNote 对字节数组进行16进制字符编码
     *
     * @param data 字节源
     * @param table 字符表
     * @return char[]
     * @author wyz
     * @date 2020/11/6 13:57
     * @modified none
     */
    private static char[] hex(final byte[] data, final char[] table){
        final int len = data.length;
        final char[] target = new char[len << 1];
        int j = 0;
        for (byte datum : data) {
            target[j++] = table[(0xF0 & datum) >>> 4];
            target[j++] = table[0x0F & datum];
        }
        return target;
    }

    /**
     * javadoc md5
     * @apiNote 取md5摘要
     *
     * @param data 数据源
     * @param upper 摘要结果是否大写
     * @return java.lang.String
     * @author wyz
     * @date 2020/11/6 13:57
     * @modified none
     */
    public static String md5(String data, boolean upper) {
        try{
            if(Objects.isNull(data) || data.length() <= 0){
                return null;
            }
            return hashCodec(data, "MD5", upper);
        }catch (Exception ex){
            throw new CommonUtilException(ex);
        }
    }


    /**
     * javadoc md5
     * @apiNote 取md5摘要, 摘要结果默认为小写
     *
     * @param data 数据源
     * @return java.lang.String
     * @author wyz
     * @date 2020/11/6 13:57
     * @modified none
     */
    public static String md5(String data) {
        try{
            if(Objects.isNull(data) || data.length() <= 0){
                return null;
            }
            return hashCodec(data, "MD5", false);
        }catch (Exception ex){
            throw new CommonUtilException(ex);
        }
    }

    /**
     * javadoc sha1
     * @apiNote sha1摘要
     *
     * @param data 数据源
     * @param upper 摘要结果是否大写
     * @return java.lang.String
     * @author wyz
     * @date 2020/11/6 13:57
     * @modified none
     */
    public static String sha1(String data, boolean upper){
        try{
            if(Objects.isNull(data) || data.length() <= 0){
                return null;
            }
            return hashCodec(data, "SHA-1", upper);
        }catch (Exception ex){
            throw new CommonUtilException(ex);
        }
    }

    /**
     * javadoc sha1
     * @apiNote sha1摘要, 摘要结果默认小写
     *
     * @param data 数据源
     * @return java.lang.String
     * @author wyz
     * @date 2020/11/6 13:57
     * @modified none
     */
    public static String sha1(String data) {
        try {
            if(Objects.isNull(data) || data.length() <= 0){
                return null;
            }
            return hashCodec(data, "SHA-1", false);
        }catch (Exception ex){
            throw new CommonUtilException(ex);
        }
    }

    /**
     * javadoc sha256
     * @apiNote sha256摘要
     *
     * @param data 数据源
     * @param upper 摘要结果是否大写
     * @return java.lang.String
     * @author wyz
     * @date 2020/11/6 13:57
     * @modified none
     */
    public static String sha256(String data, boolean upper)  {
        try{
            if(Objects.isNull(data) || data.length() <= 0){
                return null;
            }
            return hashCodec(data, "SHA-256", upper);
        }catch (Exception ex){
            throw new CommonUtilException(ex);
        }
    }

    /**
     * javadoc sha256
     * @apiNote sha256摘要, 摘要结果小写
     *
     * @param data 数据源
     * @return java.lang.String
     * @author wyz
     * @date 2020/11/6 13:57
     * @modified none
     */
    public static String sha256(String data) {
        try{
            if(Objects.isNull(data) || data.length() <= 0){
                return null;
            }
            return hashCodec(data, "SHA-256", false);
        }catch (Exception ex){
            throw new CommonUtilException(ex);
        }
    }

    /**
     * javadoc base64
     * @apiNote 普通base64编码实现, 如需使用url编码或mime资源编码请联系本项目人员
     *
     * @param data 数据源
     * @return java.lang.String
     * @author wyz
     * @date 2020/11/6 13:57
     * @modified none
     */
    public static String base64(byte[] data){
        final byte[] target = Base64.getEncoder().encode(data);
        return new String(target, StandardCharsets.UTF_8);
    }

    /**
     * javadoc base64
     * @apiNote 普通base64编码实现, 如需使用url编码或mime资源编码请联系本项目人员
     *
     * @param data 数据源
     * @return java.lang.String
     * @author wyz
     * @date 2020/11/6 13:57
     * @modified none
     */
    public static String base64(String data){
        if(Objects.isNull(data)){
            return null;
        }
        return base64(data.getBytes(StandardCharsets.UTF_8));
    }


    /**
     * javadoc urlEncode
     * @apiNote encode url for special char
     *
     * @param url origin url
     * @return java.lang.String
     * @author wyz
     * @date 2020/11/6 13:57
     * @modified none
     */
    public static String urlEncode(String url){
        if(Objects.isNull(url)){
            return null;
        }
        try {
            return URLEncoder.encode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new CommonUtilException(e);
        }
    }

    /**
     * javadoc urlDecode
     * @apiNote decode url
     *
     * @param url encoded url
     * @return java.lang.String
     * @author wyz
     * @date 2020/11/6 13:57
     * @modified none
     */
    public static String urlDecode(String url){
        if(Objects.isNull(url)){
            return null;
        }
        try {
            return URLDecoder.decode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new CommonUtilException(e);
        }
    }

}
