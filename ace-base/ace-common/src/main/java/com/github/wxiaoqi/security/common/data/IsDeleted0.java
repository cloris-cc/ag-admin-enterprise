/*






 *
 */

package com.github.wxiaoqi.security.common.data;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author woozoom
 * @create 2018/2/9.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD,ElementType.TYPE})
public @interface IsDeleted0 {
    String isDeleted0Field() default "isDeleted0";
}
