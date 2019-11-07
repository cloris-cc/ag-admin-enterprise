package com.woozoom.config;

import com.github.wxiaoqi.security.auth.client.interceptor.ServiceFeignInterceptor;
import org.springframework.context.annotation.Bean;

/**
 * @author woozoom
 * @version 2018/1/18.
 */
public class TxFeignConfiguration {

    @Bean
    public ServiceFeignInterceptor serviceFeignInterceptor(){
        return new ServiceFeignInterceptor();
    }
}
