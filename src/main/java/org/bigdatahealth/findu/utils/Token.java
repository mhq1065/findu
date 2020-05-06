package org.bigdatahealth.findu.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.commons.lang3.StringUtils;
import org.bigdatahealth.findu.pojo.User;


import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Token {


    /** token秘钥，请勿泄露，请勿随便修改 backups:JKKLJOoasdlfj */
    public static final String SECRET = "JKKLJOoasdlfj";
    /** token 过期时间: 10天 */
    public static final int calendarField = Calendar.DATE;
    public static final int calendarInterval = 1000;

    /**
     * JWT生成Token.<br/>
     *
     * JWT构成: header, payload, signature
     *            登录成功后用户信息user
     */
    public static String createToken(User user){
        Date iatDate = new Date();
        // expire time
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(calendarField, calendarInterval);
        Date expiresDate = nowTime.getTime();

        // header Map
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");

        // build token
        // param backups {iss:Service, aud:APP}
        String token = null; // signature
        try {
            token = JWT.create().withHeader(map) // header
                    .withClaim("iss", "Service") // payload
                    .withClaim("aud", "APP")
                    .withClaim("userId", null == user.getUserId() ? null : user.getUserId())
                    .withIssuedAt(iatDate) // sign time
                    .withExpiresAt(expiresDate) // expire time
                    .sign(Algorithm.HMAC256(SECRET));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return token;
    }


    /**
     * 根据Token获取user_id
     *
     * @param token
     * @return user_id
     */
    public static Long getUserId(String token) {
        Map<String, Claim> claims = verifyToken(token);
        Claim userAccountClaim = claims.get("userId");
        if (null == userAccountClaim) {
            // token 校验失败, 抛出Token验证非法异常
            return null;
        }
        return userAccountClaim.asLong();
    }


    /**
     * 解密Token
     *
     * @param token
     * @return
     * @throws Exception
     */
    public static Map<String, Claim> verifyToken(String token) {
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            jwt = verifier.verify(token);
        } catch (Exception e) {
            // e.printStackTrace();
            // token 校验失败, 抛出Token验证非法异常
        }
        return jwt.getClaims();
    }

}
