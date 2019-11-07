package com.woozoom.biz;

import com.github.wxiaoqi.security.common.biz.BusinessBiz;
import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import com.woozoom.entity.Shop;
import com.woozoom.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 *
 * @author WOOZOOM
 * @email 
 * @version 2018-09-29 10:17:25
 */
@Service
public class ShopBiz extends BusinessBiz<ShopMapper,Shop> {
    @Autowired
    private ShopMapper shopMapper;

    @Transactional
    public ObjectRestResponse<Shop> insert(Shop entity) {
        super.insertSelective(entity);
        return new ObjectRestResponse<Shop>().data(entity);
    }
}