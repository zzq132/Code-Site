package com.zzz.codesite.pojo;

import lombok.Data;

@Data
public class Response {
    private int code;
    private String message;
    private Object data;

    public static Response success(Object data){
        Response response = success();
        response.data=data;
        return response;
    }

    public static Response success(){
        Response response=new Response();
        response.code=1;
        response.message="Success";
        return response;
    }

    public static Response error(String error){
        Response response=new Response();
        response.code=0;
        response.message=error;
        return response;
    }
}
