package com.net.jianshu.util;

public class MyExcption extends   RuntimeException{
    private String code;
    private String msg;

    public MyExcption(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public MyExcption(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public MyExcption setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public MyExcption setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
