package com.bs.grad.util;

public class Result {
    public static Msg success(Object object) {
        Msg msg = new Msg();
        msg.getCode(200);
        msg.setMsg("请求成功");
        msg.setData(object);
        return msg;
    }
    public static Msg success(){
        return success(null);
    }
    public static Msg error(Integer code,String resultmsg) {
        Msg msg = new Msg();
        msg.setCode(code);
        msg.setMsg(resultmsg);
        return msg;
    }
}