package com.github.wxiaoqi.security.api.vo.shop;

import java.io.Serializable;


/**
 * 
 * 
 * @author woozoom
 *
 * @version 2018-09-19 15:18:36
 */
public class Shop implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    private Integer id;
	
	    //
    private String name;
	

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
}
