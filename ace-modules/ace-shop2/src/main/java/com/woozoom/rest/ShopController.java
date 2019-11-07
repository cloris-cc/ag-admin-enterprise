package com.woozoom.rest;

import com.github.wxiaoqi.security.auth.client.annotation.CheckClientToken;
import com.github.wxiaoqi.security.auth.client.annotation.CheckUserToken;
import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import com.github.wxiaoqi.security.common.rest.BaseController;
import com.woozoom.biz.ShopBiz;
import com.woozoom.entity.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test/test")
@CheckClientToken
@CheckUserToken
public class ShopController extends BaseController<ShopBiz, Shop,Integer> {

    @Autowired
    private ShopBiz shopBiz;

    @Override
    @ResponseBody
    public ObjectRestResponse<Shop> add(@RequestBody Shop shop) {
//        super.add(shop);
        return shopBiz.insert(shop);
    }
}