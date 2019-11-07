package com.woozoom.mapper;

import com.github.wxiaoqi.security.common.data.IsDeleted0;
import com.github.wxiaoqi.security.common.data.Depart;
import com.github.wxiaoqi.security.common.data.IsDeleted1;
import com.github.wxiaoqi.security.common.data.Tenant;
import com.github.wxiaoqi.security.common.mapper.CommonMapper;
import com.woozoom.entity.Student;

import java.util.List;

/**
 * 
 * 
 * @author woozoom
 *
 * @version 2018-09-19 16:18:03
 */
@Depart
@Tenant
@IsDeleted0
public interface StudentMapper extends CommonMapper<Student> {
    List<Student> select1();
}
