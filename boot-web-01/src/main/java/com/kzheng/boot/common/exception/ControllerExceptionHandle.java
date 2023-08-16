package com.kzheng.boot.common.exception;

import com.kzheng.boot.common.response.R;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/7/28 13:19
 */
@RestControllerAdvice//主要用来处理全局数据，一般搭配@ExceptionHandler、@ModelAttribute以及@InitBinder使用
public class ControllerExceptionHandle {
    public R<CustomException> handle(CustomException e){
        e.printStackTrace();
        return R.exception(e.getCode(),e.getMessage());
    }
}
