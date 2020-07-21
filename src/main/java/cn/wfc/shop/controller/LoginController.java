package cn.wfc.shop.controller;

import cn.wfc.shop.entity.MyUser;
import cn.wfc.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String hello(){
        return "index";
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }
}
