/*





 */

package com.github.wxiaoqi.security.auth.client.runner;

import com.github.wxiaoqi.security.auth.client.config.ServiceAuthConfig;
import com.github.wxiaoqi.security.auth.client.config.UserAuthConfig;
import com.github.wxiaoqi.security.auth.client.feign.ServiceAuthFeign;
import com.github.wxiaoqi.security.common.msg.BaseResponse;
import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 监听完成时触发
 *
 * @author woozoom
 * @version 2017/11/29.
 */
@Configuration
@Slf4j
public class AuthClientRunner implements CommandLineRunner {
    @Autowired
    private ServiceAuthConfig serviceAuthConfig;
    @Autowired
    private UserAuthConfig userAuthConfig;
    @Autowired
    private ServiceAuthFeign serviceAuthFeign;

    @Override
    public void run(String... args) throws Exception {
        try {
            refreshUserPubKey();
            log.info("完成初始化加载用户pubKey");
        }catch(Exception e){
            log.error("初始化加载用户pubKey失败,请检查auth服务是否正常启动,1分钟后自动重试!",e);
        }
        try {
            refreshServicePubKey();
            log.info("完成初始化加载客户pubKey");
        }catch(Exception e){
            log.error("初始化加载客户pubKey失败,请检查auth服务是否正常启动,1分钟后自动重试!",e);
        }
    }
    @Scheduled(cron = "0 0/1 * * * ?")
    public void refreshUserPubKey(){
        BaseResponse resp = serviceAuthFeign.getUserPublicKey(serviceAuthConfig.getClientId(), serviceAuthConfig.getClientSecret());
        if (resp.getStatus() == HttpStatus.OK.value()) {
            ObjectRestResponse<byte[]> userResponse = (ObjectRestResponse<byte[]>) resp;
            this.userAuthConfig.setPubKeyByte(userResponse.getData());
        }
    }
    @Scheduled(cron = "0 0/1 * * * ?")
    public void refreshServicePubKey(){
        BaseResponse resp = serviceAuthFeign.getServicePublicKey(serviceAuthConfig.getClientId(), serviceAuthConfig.getClientSecret());
        if (resp.getStatus() == HttpStatus.OK.value()) {
            ObjectRestResponse<byte[]> userResponse = (ObjectRestResponse<byte[]>) resp;
            this.serviceAuthConfig.setPubKeyByte(userResponse.getData());
        }
    }
}
