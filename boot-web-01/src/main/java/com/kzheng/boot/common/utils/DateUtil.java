package com.kzheng.boot.common.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/7/28 13:37
 */
public class DateUtil {
    public static Date getDateOffSetMinute(Integer minute){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, minute);
        return cal.getTime();
    }
}
