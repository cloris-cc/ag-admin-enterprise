/*





 */

package com.woozoom.feign;

import com.woozoom.config.TxFeignConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * ${DESCRIPTION}
 *
 * @author woozoom
 * @version 2017-06-21 8:11
 */
@FeignClient(value = "ace-transaction-demo1",configuration = TxFeignConfiguration.class)
public interface IDemo1Service {

  @RequestMapping("/account/test")
  public void testFeign();
}
