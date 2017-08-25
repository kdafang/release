package io.renren.util;

import java.io.Serializable;

/**
 * Created by kdafang on 2017/8/25.
 */
public class AjaxResponse implements Serializable {
    private int code = ErrorCode.SUCCESS;	//默认成功
    private String message = "操作成功！";

    //业务数据
    private Object data;

    public AjaxResponse() {
        super();
    }
    public AjaxResponse(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }
    public AjaxResponse(Object data) {
        super();
        this.data = data;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
}
