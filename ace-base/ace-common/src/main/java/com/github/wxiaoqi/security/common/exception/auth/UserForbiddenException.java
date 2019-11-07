/*





 */

package com.github.wxiaoqi.security.common.exception.auth;


import com.github.wxiaoqi.security.common.constant.RestCodeConstants;
import com.github.ag.core.exception.BaseException;

/**
 *
 * @author woozoom
 * @version 2017/9/12
 */
public class UserForbiddenException extends BaseException {
    public UserForbiddenException(String message) {
        super(message, RestCodeConstants.EX_USER_FORBIDDEN_CODE);
    }

}
