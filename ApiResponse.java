package com.money.common;

import com.google.common.collect.Maps;

import java.util.Date;

public class ApiResponse {

    public static int CODE_DEFAULT__SUCCESS = 200;

    /**
     * 默认code:服务器异常
     */
    public static int CODE_DEFAULT__EXCEPTION = 201;

    /**
     * 默认code:参数错误
     */
    public static int CODE_DEFAULT__PARAM_ERROR = 202;

    /**
     * 默认code:token错误
     */
    public static int CODE_DEFAULT__TOKEN_ERROR = 203;

    /**
     * 默认code:账户被冻结
     */
    public static int CODE_DEFAULT__FROZEN_ERROR = 204;

    private int code;
    private String msg;
    private Date serverTime;
    private Object data;

    public ApiResponse(){
        super();
    }

    /**
     * @param code
     * @param msg
     * @param data 字典类型或者java bean对象
     */
    private ApiResponse(int code,String msg,Object data){
        this.code = code;
        if(msg == null){
            this.msg = "";
        }else{
            this.msg = msg;
        }
        if(data == null){
            this.data = Maps.newHashMap();
        }else{
            this.data = data;
        }

    }

    public static ApiResponse success(){
        return new ApiResponse(CODE_DEFAULT__SUCCESS,"success",null);
    }

    /**
     * @param data 字典类型或者java bean对象
     * @return
     */
    public static ApiResponse success(Object data){
        String msg_ = "success";
        if (data != null && (data instanceof String)){
            msg_ = (String) data;
            data = null;
        }
        return new ApiResponse(CODE_DEFAULT__SUCCESS, msg_,data);
    }
    
    public static ApiResponse error(){
    	return error("参数错误");
    }

    public static ApiResponse error(String msg){
        return error(CODE_DEFAULT__PARAM_ERROR,msg);
    }

    public static ApiResponse error(int code, String msg){
        return new ApiResponse(code,msg, null);
    }

    /**
     * @param code
     * @param msg
     * @param data 字典类型或者java bean对象
     * @return
     */
    public static ApiResponse error(int code, String msg,Object data){
        return new ApiResponse(code,msg, data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public ApiResponse setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    /**
     *
     * @return 字典类型或者java bean对象
     */
    public Object getData() {
        return data == null ? Maps.newHashMap() : data;
    }

    /**
     * @param data 字典类型或者java bean对象
     */
    public void setData(Object data) {
        this.data = data;
    }

    public Date getServerTime() {
        return new Date();
    }

    public void setServerTime(Date serverTime) {
        this.serverTime = serverTime;
    }
}
