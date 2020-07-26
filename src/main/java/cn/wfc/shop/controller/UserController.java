package cn.wfc.shop.controller;

import cn.wfc.shop.entity.MyUser;
import cn.wfc.shop.service.UserService;
import cn.wfc.shop.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public ModelAndView list(ModelAndView modelAndView) {
        User user = SecurityUtil.getLoginUser();
        modelAndView.addObject("username", user.getUsername());
        modelAndView.setViewName("user_list");
        List<MyUser> users = userService.findAll();
        modelAndView.addObject("users", users);
        return modelAndView;
    }
    @RequestMapping("/toAdd")
    public ModelAndView add(ModelAndView modelAndView) {
        modelAndView.setViewName("user_add");
        return modelAndView;
    }
}
