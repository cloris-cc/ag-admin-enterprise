package com.woozoom.biz;

import com.codingapi.tx.config.service.TxManagerTxUrlService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * create by lorne on 2017/11/18
 */
@Service
public class TxManagerTxUrlBiz implements TxManagerTxUrlService{


    @Value("${tm.manager.url}")
    private String url;

    @Override
    public String getTxUrl() {
        return url;
    }
}
