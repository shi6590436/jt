package com.net.jianshu.util;

import java.io.Serializable;

public class JsonData implements Serializable{
    private String code;
    private String msg;
    private Object data;

    public JsonData(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JsonData(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public JsonData setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public JsonData setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public JsonData setData(Object data) {
        this.data = data;
        return this;
    }
}
