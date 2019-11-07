/*





 */

package com.github.wxiaoqi.security.common.exception.auth;


import com.github.wxiaoqi.security.common.constant.RestCodeConstants;
import com.github.ag.core.exception.BaseException;

/**
 * Created by woozoom on 2018/9/8.
 */
public class NonLoginException extends BaseException {
    public NonLoginException(String message) {
        super(message, RestCodeConstants.EX_USER_INVALID_CODE);
    }
}
