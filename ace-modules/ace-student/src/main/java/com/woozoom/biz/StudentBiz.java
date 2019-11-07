package com.woozoom.biz;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.wxiaoqi.security.common.biz.BusinessBiz;
import com.github.wxiaoqi.security.common.msg.TableResultResponse;
import com.github.wxiaoqi.security.common.util.Query;
import com.woozoom.entity.Student;
import com.woozoom.feign.IDemo1Service;
import com.woozoom.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * 
 *
 * @author woozoom
 *
 * @version 2018-09-19 16:18:03
 */
@Service
public class StudentBiz extends BusinessBiz<StudentMapper, Student> {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private IDemo1Service iDemo1Service;

    /*@Override
    public TableResultResponse<Student> selectByQuery(Query query) {
       *//* Class<Student> clazz = (Class<Student>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        Example example = new Example(clazz);
        query2criteria(query, example);*//*
        Page<Object> result = PageHelper.startPage(query.getPage(), query.getLimit());
        List<Student> list = studentMapper.selectByPage();
        return new TableResultResponse<Student>(result.getTotal(), list);
    }*/

    public void test(){
        iDemo1Service.testFeign();
//        int i =  1/0;
    }

    public List<Student> select() {
        return studentMapper.select1();
    }
}