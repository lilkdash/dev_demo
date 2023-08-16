package com.kzheng.boot.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author kaizheng
 * @Description 响应状态码
 * @Date 2023/7/28 12:46
 */
@Getter
@AllArgsConstructor
public enum ResponseEnum {
    SUCCESS(200,"操作成功"),
    FAIL(201,"获取数据失败"),
    NO_TOKEN(400,"无token，请重新登陆"),
    TOKEN_EX(401,"token验证失败，请重新登陆"),
    USER_EX(402,"用户不存在，请重新登陆"),
    ERROR(400,"错误请求");

    private final Integer code;
    private final String resultMsg;


    public static ResponseEnum getResultCode(Integer code){
        for (ResponseEnum value : ResponseEnum.values()) {
            if(code.equals(value.getCode())){
                return value;
            }
        }
        return ResponseEnum.ERROR;
    }

    public static void main(String[] args) {
        ResponseEnum resultCode=ResponseEnum.getResultCode(200);
        System.out.println(resultCode);
    }
}
