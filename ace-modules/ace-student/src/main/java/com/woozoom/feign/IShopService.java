/*





 */

package com.woozoom.feign;

import com.github.wxiaoqi.security.api.vo.shop.Shop;
import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import com.woozoom.config.TxFeignConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


/**
 * ${DESCRIPTION}
 *
 * @author woozoom
 * @version 2017-06-21 8:11
 */
@FeignClient(value = "ace-shop",configuration = TxFeignConfiguration.class)
public interface IShopService {

  @RequestMapping(value = "/shop/test/selectAll", method = RequestMethod.POST)
  public ObjectRestResponse<List<Shop>> selectAll(@RequestParam("parm1") String parm1, @RequestParam("parm2") String parm2);
}
