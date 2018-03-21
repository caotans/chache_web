package com.ct.controller;
import com.alibaba.fastjson.JSONObject;
import com.ct.entity.UserLoginInfo;
import com.ct.service.CustomerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    @RequestMapping("/login")
    public String login(ModelMap modelMap){
        return "login";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public void add(HttpServletRequest request
    ,@RequestParam(value="userLoginInfo", required=false) String userLoginInfo

    ){
        String result="0";
        try {
            JSONObject jsonObject=JSONObject.parseObject(userLoginInfo);
            customerService.addUser(jsonObject);
            result="1";
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
        }

    }

    @RequestMapping("/del")
    @ResponseBody
    public String del(HttpServletRequest request,@RequestParam(value="weChatNum", required=false) String weChatNum){
        String result="0";
        try {
            customerService.deleteUser("weChatNum",weChatNum,"userLoginInfo");
            result="1";
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
        }

        return result;
    }

    /**
     * 设置为会员
     * @param request
     * @param weChatNum
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public String update(HttpServletRequest request,@RequestParam(value="weChatNum", required=false) String weChatNum){
        String result="0";
        try {
            UserLoginInfo userLoginInfo=new UserLoginInfo();
            customerService.updateUser("weChatNum",weChatNum,"userLoginInfo","insider", 1);
            result="1";
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
        }

        return result;
    }

    /**
     * 设置为会员
     * @param request
     * @param weChatNum
     * @return
     */
    @RequestMapping("/findUser")
    @ResponseBody
    public String findUser(HttpServletRequest request,@RequestParam(value="weChatNum", required=false) String weChatNum){
        String result="0";
        try {
            if(weChatNum==null){
                return result;
            }
            UserLoginInfo userLoginInfo=new UserLoginInfo();
            UserLoginInfo user= customerService.findUserByWeChatNum(weChatNum);
            if(user!=null){
                result="1";
            }

        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
        }

        return result;
    }
}