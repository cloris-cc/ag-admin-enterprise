/*





 */

package com.github.wxiaoqi.security.common.msg;

/**
 * Created by woozoom on 2018/6/11.
 */
public class ObjectRestResponse<T> extends BaseResponse {

    T data;

    public ObjectRestResponse data(T data) {
        this.setData(data);
        return this;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static ObjectRestResponse ok(Object data) {
        return new ObjectRestResponse<Object>().data(data);
    }

    public static ObjectRestResponse ok() {
        return new ObjectRestResponse<Object>();
    }
}
