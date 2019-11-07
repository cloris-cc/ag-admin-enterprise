package com.github.ag.core.util;

/**
 * Created by woozoom on 2018/9/10.
 */
public class StringHelper {
    public static String getObjectValue(Object obj){
        return obj==null?"":obj.toString();
    }
}
