package com.woozoom.rest;

import com.github.wxiaoqi.security.auth.client.annotation.CheckClientToken;
import com.github.wxiaoqi.security.auth.client.annotation.CheckUserToken;
import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import com.github.wxiaoqi.security.common.rest.BaseController;
import com.woozoom.biz.ShopBiz;
import com.github.wxiaoqi.security.api.vo.shop.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("shop/test")
//@CheckClientToken
@CheckUserToken
public class ShopController extends BaseController<ShopBiz, Shop,Integer> {

    @Autowired
    private ShopBiz shopBiz;

    @RequestMapping(value = "/selectAll", method = RequestMethod.POST)
    public ObjectRestResponse<List<Shop>>  selectAll(String parm1, String parm2) {
        return new ObjectRestResponse<List<Shop>>().data(super.all());
    }
}