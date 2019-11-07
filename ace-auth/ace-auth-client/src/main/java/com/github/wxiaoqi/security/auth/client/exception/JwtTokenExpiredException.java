/*





 */

package com.github.wxiaoqi.security.auth.client.exception;

/**
 * Created by woozoom on 2018/9/15.
 */
public class JwtTokenExpiredException extends Exception {
    public JwtTokenExpiredException(String s) {
        super(s);
    }
}
