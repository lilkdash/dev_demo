package com.kzheng.boot.controller;

import com.alibaba.fastjson.JSONObject;
import com.kzheng.boot.common.annotation.PassToken;
import com.kzheng.boot.common.log.UserRequeBody;
import com.kzheng.boot.entity.TUser;
import com.kzheng.boot.common.annotation.MethodLog;
import com.kzheng.boot.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/7/27 23:24
 */
@Controller
public class TUserController {
    @Autowired
    private TUserService tUserService;

    @GetMapping("/getUserById")
    @PassToken
    public TUser getUserById(@RequestParam("id") int id) {
        return tUserService.getUserById(id);
    }

    @GetMapping("/getUserByUserId")
    public TUser getUserByUserId(@RequestParam("userId") String userId) {
        return tUserService.getUserByUserId(userId);
    }
    @ResponseBody
    @PostMapping("/user/login")
    @PassToken
    public Object login(@RequestParam("username") String userId,@RequestParam("password") String password,Model model, HttpServletRequest request){
        JSONObject jsonObject=new JSONObject();
        TUser tUser=tUserService.login(userId,password);
        if (tUser!=null){
            jsonObject.put("code",1);
            jsonObject.put("msg","登陆成功");
            jsonObject.put("success",true);
            jsonObject.put("type","success");
            jsonObject.put("userMsg",tUser);
        }else {
            jsonObject.put("code",0);
            jsonObject.put("success",false);
            jsonObject.put("msg","用户名或密码错误");
            jsonObject.put("type","error");
        }
        return jsonObject;
    }
    @PassToken
    @RequestMapping(value = {"", "/", "/index"}, method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {
        TUser user = (TUser) request.getSession().getAttribute("user");
        model.addAttribute("user", user);
        return "redirect:/index.html";
    }
    @PassToken
    @RequestMapping(value = {"/loginIndex"}, method = RequestMethod.GET)
    public String loginIndex() {
        return "redirect:/login.html";
    }

    /**
     *  @MethodLog自定义日志注解的使用
     * @param id
     * @return
     */
    @PassToken
    @GetMapping("/getUserById2")
    @ResponseBody
    @MethodLog
    public boolean getUserById2(@RequestParam("id") Integer id) {
        return tUserService.getUserById2(id);
    }

    /**
     * ResponseBodyAdvice日志必须和@RequestBody结合使用
     * @param requeBody
     * @return
     */
    @PassToken
    @PostMapping("/getUserById3")
    public boolean getUserById3(@RequestBody TUser requeBody) {
        return tUserService.getUserById2(requeBody.getId());
    }
}