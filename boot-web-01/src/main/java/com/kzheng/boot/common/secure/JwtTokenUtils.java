package com.kzheng.boot.common.secure;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.kzheng.boot.common.utils.DateUtil;

/**
 * @Author kaizheng
 * @Description 整合JWT生成token
 * @Date 2023/7/28 13:27
 */
public class JwtTokenUtils {
    private JwtTokenUtils(){
        throw new IllegalStateException("Utility class");
    }
    public static String getToken(String userId,String sign){
        return JWT.create()
                //签收者
                .withAudience(userId)
                //主题
                .withSubject("token")
                //token过期时间
                .withExpiresAt(DateUtil.getDateOffSetMinute(30))
                //以password作为token密钥
                .sign(Algorithm.HMAC256(sign));
    }
}
