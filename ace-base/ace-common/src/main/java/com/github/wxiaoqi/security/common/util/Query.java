/*





 */

package com.github.wxiaoqi.security.common.util;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 查询参数
 */
public class Query extends LinkedHashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	//当前页码
    private int page = 1;
    //每页条数
    private int limit = 10;

    private String orderByField = "";
    private String isAsc = "";

    public Query(Map<String, Object> params){
        this.putAll(params);
        //分页参数
        if(params.get("page")!=null) {
            this.page = Integer.parseInt(params.get("page").toString());
        }
        if(params.get("limit")!=null) {
            this.limit = Integer.parseInt(params.get("limit").toString());
        }

        if(params.get("orderByField")!=null) {
            this.orderByField = params.get("orderByField").toString();
        }
        if(params.get("isAsc")!=null) {
            this.isAsc = params.get("isAsc").toString();
        }
        this.remove("page");
        this.remove("limit");
        this.remove("orderByField");
        this.remove("isAsc");
    }


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getOrderByField() {
        return orderByField;
    }

    public void setOrderByField(String orderByField) {
        this.orderByField = orderByField;
    }

    public String getIsAsc() {
        return isAsc;
    }

    public void setIsAsc(String isAsc) {
        this.isAsc = isAsc;
    }
}
