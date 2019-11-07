/*





 */

package com.github.wxiaoqi.gate.ratelimit.config;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by woozoom on 2018/9/23.
 */
public class DefaultUserPrincipal implements IUserPrincipal {
    @Override
    public String getName(HttpServletRequest request) {
        if(request.getUserPrincipal()==null) {
            return null;
        }
        return request.getUserPrincipal().getName();
    }
}
