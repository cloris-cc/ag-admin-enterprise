/*





 */

package com.github.wxiaoqi.security.auth.client.config;

import com.github.wxiaoqi.security.auth.client.interceptor.ServiceFeignInterceptor;
import org.springframework.context.annotation.Bean;

/**
 * Created by woozoom on 2018/9/12.
 */
public class FeignApplyConfiguration {
    @Bean
    ServiceFeignInterceptor getClientTokenInterceptor(){
        return new ServiceFeignInterceptor();
    }
}
