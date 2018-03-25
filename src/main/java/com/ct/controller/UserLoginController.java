package com.ct.controller;

import com.alibaba.fastjson.JSONObject;
import com.ct.entity.UserLoginInfo;
import com.ct.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserLoginController {
    private static Logger logger = LoggerFactory.getLogger(UserLoginController.class);
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/index")
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("name", "成功!");
        return "index";
    }



    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public void add(HttpServletRequest request
            , @RequestParam(value = "userLoginInfo", required = false) String userLoginInfo

    ) {
        String result = "0";
        try {
            JSONObject jsonObject = JSONObject.parseObject(userLoginInfo);
            customerService.addUser(jsonObject);
            result = "1";
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }

    }

    @RequestMapping("/del")
    @ResponseBody
    public String del(HttpServletRequest request, @RequestParam(value = "weChatNum", required = false) String weChatNum) {
        String result = "0";
        try {
            customerService.deleteUser("weChatNum", weChatNum, "userLoginInfo");
            result = "1";
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }

        return result;
    }

    /**
     * 设置为会员
     *
     * @param request
     * @param weChatNum
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public String update(HttpServletRequest request, @RequestParam(value = "weChatNum", required = false) String weChatNum) {
        String result = "0";
        try {
            UserLoginInfo userLoginInfo = new UserLoginInfo();
            customerService.updateUser("weChatNum", weChatNum, "userLoginInfo", "insider", 1);
            result = "1";
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }

        return result;
    }

    /**
     * 设置为会员
     *
     * @param request
     * @param weChatNum
     * @return
     */
    @RequestMapping("/findUser")
    @ResponseBody
    public String findUser(HttpServletRequest request, @RequestParam(value = "weChatNum", required = false) String weChatNum) {
        String result = "0";
        try {
            if (weChatNum == null) {
                return result;
            }
            UserLoginInfo userLoginInfo = new UserLoginInfo();
            UserLoginInfo user = customerService.findUserByWeChatNum(weChatNum);
            if (user != null) {
                result = "1";
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }

        return result;
    }





    //代购的代码**********************************************************************************************
    @RequestMapping("/login")
    public String login(ModelMap modelMap) {
        logger.info("33333333333333333");
        logger.error("33333333333333333");
        return "login";
    }

    @RequestMapping("/regist")
    public String regist(ModelMap modelMap) {
        return "regist";
    }


    @RequestMapping(value = "/regist_start", method = RequestMethod.POST)
    @ResponseBody
    public String  regist_start(HttpServletRequest request,HttpServletResponse response
                                ,@RequestBody JSONObject jsonObject

    ) {
        String result = "0";//0是失败
        try {
            customerService.regist_start(jsonObject.getJSONObject("userInfo"),"user");
            result = "1";//1是成功
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return result;
    }

    /**
     *
     *账号是否存在
     * @param request
     * @param response
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = "/accountIsExist", method = RequestMethod.POST)
    @ResponseBody
    public boolean  accountIsExist(HttpServletRequest request,HttpServletResponse response
            ,@RequestBody JSONObject jsonObject

    ) {
        boolean result = false;//0是失败
        try {
            result = customerService.accountIsExist(jsonObject,"user");

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return result;
    }

    /**
     *
     *登陆
     * @param request
     * @param response
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = "/jumpToMain", method = RequestMethod.POST)
    @ResponseBody
    public String  jumpToMain(HttpServletRequest request,HttpServletResponse response
            ,@RequestBody JSONObject jsonObject

    ) {
        String result = "no";//默认是账号不存在的
        try {
            result = customerService.jumpToMain(jsonObject,"user");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return result;
    }

}