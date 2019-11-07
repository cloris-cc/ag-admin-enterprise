package com.woozoom.rest;

import com.github.wxiaoqi.security.auth.client.annotation.CheckClientToken;
import com.github.wxiaoqi.security.auth.client.annotation.CheckUserToken;
import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import com.github.wxiaoqi.security.common.rest.BaseController;
import com.woozoom.biz.ShopBiz;
import com.woozoom.entity.Shop;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("test/test")
@CheckClientToken
@CheckUserToken
public class ShopController extends BaseController<ShopBiz, Shop,Integer> {

    @Autowired
    private ShopBiz shopBiz;

    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public ObjectRestResponse<Shop> add1(@RequestBody Shop shop) {
//        Shop bean = new Shop();
//        BeanUtils.copyProperties(shop, bean);
        return shopBiz.insert(shop);
    }
}