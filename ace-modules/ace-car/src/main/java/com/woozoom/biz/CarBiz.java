package com.woozoom.biz;

import com.github.wxiaoqi.security.common.biz.BusinessBiz;
import com.woozoom.entity.Car;
import com.woozoom.mapper.CarMapper;
import org.springframework.stereotype.Service;

/**
 * 
 *
 * @author woozoom
 *
 * @version 2018-09-19 16:18:03
 */
@Service
public class CarBiz extends BusinessBiz<CarMapper, Car> {
}