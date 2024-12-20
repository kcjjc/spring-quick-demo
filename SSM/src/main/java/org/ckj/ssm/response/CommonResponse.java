package org.ckj.ssm.response;

import java.io.Serializable;

/**
 * @Author: ckj
 * @CreateTime: 2024-11-08  14:34
 * @Description:通用返回类
 * @Version: 1.0
 */
public class CommonResponse<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer code;
    private String msg;
    private T data;

    public CommonResponse() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> CommonResponse<T> success(String msg) {
        CommonResponse<T> response = new CommonResponse<>();
        response.setCode(200);
        response.setMsg(msg);
        return response;
    }

    public static <T> CommonResponse<T> success(String msg, T data) {
        CommonResponse<T> response = new CommonResponse<>();
        response.setCode(200);
        response.setMsg(msg);
        response.setData(data);
        return response;
    }

    public static <T> CommonResponse<T> failure(String msg) {
        CommonResponse<T> response = new CommonResponse<>();
        response.setCode(500);
        response.setMsg(msg);
        return response;
    }

    public static <T> CommonResponse<T> failure(Integer code, String msg) {
        CommonResponse<T> response = new CommonResponse<>();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }
}
