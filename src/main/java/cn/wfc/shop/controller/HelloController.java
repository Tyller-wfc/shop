package cn.wfc.shop.controller;

import cn.wfc.shop.entity.MyUser;
import cn.wfc.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public ModelAndView hello(String name){
        MyUser user = userService.findUserByName(name);
        ModelAndView mav = new ModelAndView();
        mav.addObject("user", user);
        mav.setViewName("hello");
        return mav;
    }
}
