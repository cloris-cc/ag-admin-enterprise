/*





 */

package com.github.wxiaoqi.security.common.exception.auth;


import com.github.wxiaoqi.security.common.constant.RestCodeConstants;
import com.github.ag.core.exception.BaseException;

/**
 * Created by woozoom on 2018/9/12.
 */
public class ClientForbiddenException extends BaseException {
    public ClientForbiddenException(String message) {
        super(message, RestCodeConstants.EX_CLIENT_FORBIDDEN_CODE);
    }

}
