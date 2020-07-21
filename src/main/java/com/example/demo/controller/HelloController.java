package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
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
        User user = userService.findUserByName(name);
        System.out.println(user.getName()+":"+user.getPassword());
        ModelAndView mav = new ModelAndView();
        mav.addObject("user", user);
        mav.setViewName("hello");
        return mav;
    }
}
