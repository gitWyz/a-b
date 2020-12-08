package com.wyz.user.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.common.collect.Maps;
import com.wyz.user.bean.enums.ResultCodeEnum;
import com.wyz.user.exception.CustomException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.Security;
import java.util.Date;
import java.util.Map;

/**javadoc SecurityUtil
 *         密码加解密util
 *
 * @author wyz
 * @date 2020/11/6 11:58
 * @version 1.0.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class SecurityUtil {
    /**
     * token 一个月过期时间
     **/
    private static final long TOKEN_EXPIRE = 30 * 24 * 60 * 60 * 100L;

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    /**
      *  javadoc makeToken
      *  @apiNote 生成token
      *
      *  @param  userCode 用户唯一code
      *  @param  key token 秘钥
      *  @return  java.lang.String
      *  @author weng xiaoyong
      *  @date 2020/5/21 10:39
      *  @modified none
      */
    public static String makeToken(String userCode, String key){
        Algorithm algorithm = Algorithm.HMAC256(key);
        final Map<String, Object> headers = Maps.newHashMap();
        headers.put("typ", "JWT");
        headers.put("alg", "HS256");
        return JWT.create()
                .withHeader(headers)
                .withClaim("userCode", userCode)
                .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRE))
                .sign(algorithm);
    }

    public static String takeUserIdFromToken(String token, String secret){
        if (StringUtils.isBlank(token) || StringUtils.isBlank(secret)){
            throw new CustomException(ResultCodeEnum.COOKIE_ILLEGAL);
        }
        try{
            final Algorithm algorithm = Algorithm.HMAC256(secret);
            final JWTVerifier verifier = JWT.require(algorithm).build();
            final DecodedJWT jwt = verifier.verify(token);
            return jwt.getClaim("userCode").asString();
        }catch (Exception ex){
            log.error("process token[{}] exception: ", token, ex);
        }
        throw new CustomException(ResultCodeEnum.COOKIE_PROCESS);
    }

    /**
      *  javadoc makeSecurity
      *  @apiNote 生成密码hash
      *
      *  @param  text 密码文本
      *  @param  salt 盐
      *  @param  key 秘钥
      *  @return  java.lang.String
      *  @author weng xiaoyong
      *  @date 2020/5/21 10:20
      *  @modified none
      */
    public static String makeSecurity(String text, String salt, String key){
        if(StringUtils.isBlank(text) || StringUtils.isBlank(key)){
            throw new CustomException(ResultCodeEnum.PARAM_ERROR);
        }
        try{
            final String sms4 = sms4(text + salt, key);
            return CodecUtil.md5(sms4, false);
        }catch (Exception ex){
            log.error("SecurityUtil.sms4({}, {}) exception: ", text + salt, key);
            throw new CustomException(ResultCodeEnum.PARAM_ERROR);
        }
    }

    /**
      *  javadoc sms4
      *  @apiNote sms4 国密算法
      *
      *  @param  source 加密源文本
      *  @param  key 加密秘钥
      *  @return  java.lang.String
      *  @author weng xiaoyong
      *  @date 2020/11/6 21:00
      *  @modified none
      */
    public static String sms4(String source, String key) throws Exception{
        if(StringUtils.isBlank(source) || StringUtils.isBlank(key)){
            throw new CustomException(ResultCodeEnum.PARAM_ERROR);
        }

        final byte[] keyBuffer = ByteUtils.fromHexString(key);
        final byte[] text = source.getBytes(StandardCharsets.UTF_8);
        final Cipher cipher = makeCipher(Cipher.ENCRYPT_MODE, keyBuffer);
        final byte[] target = cipher.doFinal(text);
        return ByteUtils.toHexString(target);

    }
    /*
    private static byte[] encryptEcbPadding(byte[] source, byte[] key) throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance("SM4/ECB/PKCS5Padding", BouncyCastleProvider.PROVIDER_NAME);
        Key sms4Key = new SecretKeySpec(key, "SM4");
        cipher.init(Cipher.ENCRYPT_MODE, sms4Key);

    }
    */

    private static Cipher makeCipher(int mode, byte[] key) throws Exception{
        Cipher cipher = Cipher.getInstance("SM4/ECB/PKCS5Padding", BouncyCastleProvider.PROVIDER_NAME);
        Key sms4Key = new SecretKeySpec(key, "SM4");
        cipher.init(mode, sms4Key);
        return cipher;
    }
}
