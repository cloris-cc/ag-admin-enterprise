package com.woozoom.rest;

import com.github.wxiaoqi.security.auth.client.annotation.CheckClientToken;
import com.github.wxiaoqi.security.auth.client.annotation.CheckUserToken;
import com.github.wxiaoqi.security.common.rest.BaseController;
import com.woozoom.biz.CarBiz;
import com.woozoom.entity.Car;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test/test")
@CheckClientToken
@CheckUserToken
public class CarController extends BaseController<CarBiz, Car,Integer> {

}