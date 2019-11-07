/*






 *
 */

package com.woozoom.service;

import com.github.wxiaoqi.security.common.data.IUserDepartDataService;
import com.woozoom.feign.IUserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author woozoom
 * @create 2018/2/11.
 */
@Component
public class UserDepartDataService implements IUserDepartDataService {
    @Autowired
    private IUserFeign userFeign;
    @Override
    public List<String> getUserDataDepartIds(String userId) {
        // 获取用户授权的数据权限部门ID列表
        return userFeign.getUserDataDepartIds(userId);
    }
}
