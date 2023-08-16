package com.kzheng.boot.common.exception;

import com.kzheng.boot.common.response.ResponseEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author kaizheng
 * @Description 自定义异常
 * @Date 2023/7/28 12:58
 */
@Data
@ApiModel
public class CustomException extends RuntimeException{
    @ApiModelProperty(value="异常状态码")
    private final Integer code;

    public CustomException(Integer code,String message) {
        super(message);
        this.code = code;
    }
    /**
     * 接受枚举类型对象
     * @param responseEnum
     */
    public CustomException(ResponseEnum responseEnum){
        super(responseEnum.getResultMsg());
        this.code = responseEnum.getCode();
    }

}

