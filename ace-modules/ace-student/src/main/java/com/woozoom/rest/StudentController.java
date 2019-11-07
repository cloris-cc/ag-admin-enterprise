package com.woozoom.rest;

import com.github.ag.core.context.BaseContextHandler;
import com.github.wxiaoqi.security.api.vo.shop.Shop;
import com.github.wxiaoqi.security.auth.client.annotation.CheckClientToken;
import com.github.wxiaoqi.security.auth.client.annotation.CheckUserToken;
import com.github.wxiaoqi.security.auth.client.config.UserAuthConfig;
import com.github.wxiaoqi.security.auth.client.jwt.ServiceAuthUtil;
import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import com.github.wxiaoqi.security.common.msg.TableResultResponse;
import com.github.wxiaoqi.security.common.rest.BaseController;
import com.woozoom.biz.StudentBiz;
import com.woozoom.entity.Student;
import com.woozoom.feign.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("test/test")
@CheckClientToken
@CheckUserToken
public class StudentController extends BaseController<StudentBiz, Student,Integer> {

    @Autowired
    private UserAuthConfig userAuthConfig;

    @Autowired
    private ServiceAuthUtil serviceAuthUtil;

    @Autowired
    private StudentBiz studentBiz;

    @Autowired
    private IShopService iShopService;

    /*@Autowired
    private IDemo1Service iDemo1Service;*/

    @Override
    @ResponseBody
    public TableResultResponse<Student> list(@RequestParam Map<String, Object> params) {
        //调用feign
//        iDemo1Service.testFeign();

//        studentBiz.test();

//        ObjectRestResponse<List<Shop>> shopList = iShopService.selectAll("1","2");
//        List<Shop> shopList1 = shopList.getData();

        String userName = BaseContextHandler.getUsername();
        String token = BaseContextHandler.getToken();
//        params.put("isAsc","desc");
//        params.put("orderByField","id");
//        int a = 1/0;
//        studentBiz.select();
        return super.list(params);
        /*Query query = new Query(params);
        return studentBiz.selectByQuery(query);*/
    }


    @Override
    @ResponseBody
    public ObjectRestResponse<Student> add(@RequestBody Student student) {
        String userID = BaseContextHandler.getUserID();
        String tenantID = BaseContextHandler.getTenantID();
        student.setCrtUserId(userID);
        student.setTenantId(tenantID);
        return super.add(student);
    }
}