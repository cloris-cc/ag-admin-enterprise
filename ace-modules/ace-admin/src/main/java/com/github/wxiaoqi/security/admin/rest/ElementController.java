/*





 */

package com.github.wxiaoqi.security.admin.rest;

import com.github.wxiaoqi.security.admin.biz.ElementBiz;
import com.github.wxiaoqi.security.admin.biz.UserBiz;
import com.github.wxiaoqi.security.admin.entity.Element;
import com.github.wxiaoqi.security.auth.client.annotation.CheckClientToken;
import com.github.wxiaoqi.security.auth.client.annotation.CheckUserToken;
import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import com.github.wxiaoqi.security.common.msg.TableResultResponse;
import com.github.wxiaoqi.security.common.rest.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author woozoom
 * @version 2017-06-23 20:30
 */
@Controller
@CheckUserToken
@CheckClientToken
@RequestMapping("element")
@Api(tags = "资源管理")
public class ElementController extends BaseController<ElementBiz, Element,String> {
  @Autowired
  private UserBiz userBiz;

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  @ResponseBody
  @ApiOperation("根据菜单获取资源")
  public TableResultResponse<Element> page(@RequestParam(defaultValue = "10") int limit,
      @RequestParam(defaultValue = "1") int offset,String name, @RequestParam(defaultValue = "0") String menuId) {
    Example example = new Example(Element.class);
    Example.Criteria criteria = example.createCriteria();
    criteria.andEqualTo("menuId", menuId);
    if(StringUtils.isNotBlank(name)){
      criteria.andLike("name", "%" + name + "%");
    }
    List<Element> elements = baseBiz.selectByExample(example);
    return new TableResultResponse<Element>(elements.size(), elements);
  }

  @RequestMapping(value = "/user", method = RequestMethod.GET)
  @ResponseBody
  @Deprecated
  public ObjectRestResponse<Element> getAuthorityElement(String menuId) {
    String userId = userBiz.getUserByUsername(getCurrentUserName()).getId();
    List<Element> elements = baseBiz.getAuthorityElementByUserId(userId + "",menuId);
    return new ObjectRestResponse<List<Element>>().data(elements);
  }

  @RequestMapping(value = "/user/menu", method = RequestMethod.GET)
  @ResponseBody
  @Deprecated
  public ObjectRestResponse<Element> getAuthorityElement() {
    String userId = userBiz.getUserByUsername(getCurrentUserName()).getId();
    List<Element> elements = baseBiz.getAuthorityElementByUserId(userId + "");
    return new ObjectRestResponse<List<Element>>().data(elements);
  }
}
