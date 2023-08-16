package com.kzheng.boot.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterController {
    // car/2
    @GetMapping("/car/{id}/owner/{username}")
        public Map<String,Object> getCar(@PathVariable("id") Integer id, @PathVariable("username") String name,
                                         @PathVariable Map<String, Object> pv, @RequestHeader("User-Agent") String userAgent,
                                         @RequestHeader Map<String,Object> header,
                                         @RequestParam("age") Integer age,
                                         @RequestParam("inters") List<String> inters,
                                         @RequestParam Map<String,Object> params
                                       ){
        HashMap<String, Object> stringObjectHashMap = new HashMap<String, Object>();
        stringObjectHashMap.put("id",id);
        stringObjectHashMap.put("name",name);
        stringObjectHashMap.put("pv",pv);
        stringObjectHashMap.put("userAgent",userAgent);
        stringObjectHashMap.put("header",header);
        stringObjectHashMap.put("age",age);
        stringObjectHashMap.put("inters",inters);
        stringObjectHashMap.put("params",params);
        //stringObjectHashMap.put("cookie_ga",cookie_ga);
        return stringObjectHashMap;
    }

    /**
     * 矩阵变量被springboot默认禁用
     * 可以通过自定义的方式解决
     * 方法一：实现WebMvcConfigurer接口，然后重写 configurePathMatch,设置urlPathHelper.setRemoveSemicolonContentt(false);
     * 方法二：容器中放一个webMvcConfig组件，WebConfig中添加
     * @param low
     * @param brand
     * @return
     */
    @GetMapping("/cars/{path}")
    public  Map<String,Object> carsSell(@MatrixVariable("low") Integer low,@MatrixVariable("brand") List<String> brand){
        HashMap<String, Object> stringObjectHashMap = new HashMap<String, Object>();
        stringObjectHashMap.put("low",low);
        stringObjectHashMap.put("brand",brand);
        return stringObjectHashMap;
    }
}
