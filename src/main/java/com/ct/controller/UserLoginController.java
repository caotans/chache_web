package com.ct.controller;
import com.ct.entity.UserLoginInfo;
import com.ct.service.CustomerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Controller
public class UserLoginController {
    private static Logger logger = Logger.getLogger(UserLoginController.class);
    @Autowired
    private CustomerService customerService;
    @RequestMapping("/index")
    public String index(ModelMap modelMap){
        modelMap.addAttribute("name","成功!");
        return "index";
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(HttpServletRequest request){
        String result="error";
        try {
            UserLoginInfo userLoginInfo=new UserLoginInfo();
            userLoginInfo.setLoginCount(1);
            userLoginInfo.setLoginTime(new Date());
            userLoginInfo.setUserName("beibei");
            userLoginInfo.setUserPhone("13223923988923");
            userLoginInfo.setWeChatNum("dsfsjdsdf");
            userLoginInfo.setIsInsider(1);
            customerService.addUser(userLoginInfo);
            result="success";
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
        }

        return result;
    }

    @RequestMapping("/del")
    @ResponseBody
    public String del(HttpServletRequest request){
        String result="error";
        try {
            UserLoginInfo userLoginInfo=new UserLoginInfo();
            customerService.addUser(userLoginInfo);
            result="success";
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
        }

        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(HttpServletRequest request){
        String result="error";
        try {
            UserLoginInfo userLoginInfo=new UserLoginInfo();
            customerService.addUser(userLoginInfo);
            result="success";
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
        }

        return result;
    }
}