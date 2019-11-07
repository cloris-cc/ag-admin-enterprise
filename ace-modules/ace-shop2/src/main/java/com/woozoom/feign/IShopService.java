/*





 */

package com.woozoom.feign;

import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import com.woozoom.config.TxFeignConfiguration;
import com.woozoom.entity.Shop;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 * ${DESCRIPTION}
 *
 * @author woozoom
 * @version 2017-06-21 8:11
 */
@FeignClient(value = "ace-shop3",configuration = TxFeignConfiguration.class)
public interface IShopService {

  @RequestMapping(value = "/test/test/add", method = RequestMethod.POST)
  public void add(@RequestBody Shop shop);
}
