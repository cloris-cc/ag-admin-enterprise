package com.woozoom.biz;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.codingapi.tx.annotation.TxTransaction;
import com.github.wxiaoqi.security.common.biz.BusinessBiz;
import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import com.woozoom.entity.Shop;
import com.woozoom.feign.IShopService;
import com.woozoom.mapper.ShopMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.parser.Entity;

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
    private IShopService iShopService;

    @TxTransaction
    @Transactional
    public ObjectRestResponse<Shop> insert(Shop entity) {
        super.insertSelective(entity);

//        com.github.wxiaoqi.security.api.vo.shop.Shop shop = new com.github.wxiaoqi.security.api.vo.shop.Shop();
//        BeanUtils.copyProperties(entity, shop);
        iShopService.add(entity);
//        int a = 1/0;
        return new ObjectRestResponse<Shop>().data(entity);
    }
}