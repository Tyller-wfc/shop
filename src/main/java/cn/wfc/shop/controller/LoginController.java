package cn.wfc.shop.controller;

import cn.wfc.shop.entity.MyUser;
import cn.wfc.shop.service.UserService;
import cn.wfc.shop.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sun.plugin.liveconnect.SecurityContextHelper;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public ModelAndView hello(ModelAndView mov){
        User user = SecurityUtil.getLoginUser();
        mov.addObject("username", user.getUsername());
        mov.setViewName("index");
        return mov;
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }
}
