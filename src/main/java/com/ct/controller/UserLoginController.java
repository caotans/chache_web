package com.ct.controller;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;
@Controller
public class UserLoginController {
    @RequestMapping("/index")
    public String index(ModelMap modelMap){
        modelMap.addAttribute("name","成功!");
        return "index";
    }
}