/*





 */

package com.github.wxiaoqi.gate.ratelimit.config;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by woozoom on 2018/9/23.
 */
public interface IUserPrincipal {
    String getName(HttpServletRequest request);
}
