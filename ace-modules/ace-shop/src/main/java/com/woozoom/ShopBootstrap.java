package com.woozoom;

import com.github.wxiaoqi.security.auth.client.EnableAceAuthClient;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author woozoom
 * @version 2017/12/26.
 */
@EnableEurekaClient
@SpringBootApplication
// 开启事务
@EnableTransactionManagement
// 开启熔断监控
@EnableCircuitBreaker
// 开启服务鉴权
@EnableFeignClients({"com.github.wxiaoqi.security.auth.client.feign","com.woozoom.feign"})
@MapperScan("com.woozoom.mapper")
@EnableAceAuthClient
@EnableSwagger2Doc
public class ShopBootstrap {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ShopBootstrap.class).web(true).run(args);    }
}
