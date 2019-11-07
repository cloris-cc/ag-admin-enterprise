/*





 */

package com.github.wxiaoqi.security.auth.client.jwt;

import com.github.ag.core.constants.CommonConstants;
import com.github.ag.core.util.jwt.IJWTInfo;
import com.github.ag.core.util.jwt.JWTHelper;
import com.github.wxiaoqi.security.auth.client.config.UserAuthConfig;
import com.github.wxiaoqi.security.common.constant.RedisKeyConstants;
import com.github.wxiaoqi.security.common.exception.auth.NonLoginException;
import com.github.wxiaoqi.security.common.util.RedisKeyUtil;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * Created by woozoom on 2018/9/15.
 */
@Configuration
public class UserAuthUtil {

    @Autowired
    private UserAuthConfig userAuthConfig;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private JWTHelper jwtHelper;

    public IJWTInfo getInfoFromToken(String token) throws Exception {
        try {
            IJWTInfo infoFromToken = jwtHelper.getInfoFromToken(token, userAuthConfig.getPubKeyByte());
            if(redisTemplate.hasKey(RedisKeyUtil.buildUserDisableKey(infoFromToken.getId(),infoFromToken.getExpireTime()))){
                throw new NonLoginException("User token is invalid!");
            }
            if(new DateTime(infoFromToken.getExpireTime()).plusMinutes(userAuthConfig.getTokenLimitExpire()).isBeforeNow()){
                redisTemplate.opsForValue().set(RedisKeyUtil.buildUserDisableKey(infoFromToken.getId(),infoFromToken.getExpireTime()), "1");
                redisTemplate.delete(RedisKeyUtil.buildUserAbleKey(infoFromToken.getId(), infoFromToken.getExpireTime()));
                throw new NonLoginException("User token expired!");
            }
            return infoFromToken;
        } catch (ExpiredJwtException ex) {
            throw new NonLoginException("User token expired!");
        } catch (SignatureException ex) {
            throw new NonLoginException("User token signature error!");
        } catch (IllegalArgumentException ex) {
            throw new NonLoginException("User token is null or empty!");
        }
    }
}
