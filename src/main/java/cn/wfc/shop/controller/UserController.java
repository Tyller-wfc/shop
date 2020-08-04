package cn.wfc.shop.controller;

import cn.wfc.shop.entity.BaseResult;
import cn.wfc.shop.entity.MyUser;
import cn.wfc.shop.service.UserService;
import cn.wfc.shop.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public ModelAndView toAdd(ModelAndView modelAndView) {
        modelAndView.setViewName("user_add");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(MyUser myUser, RedirectAttributes redirectAttributes) {
        BaseResult baseResult = userService.add(myUser);
        redirectAttributes.addFlashAttribute("baseResult", baseResult);
        redirectAttributes.addFlashAttribute("myUser", myUser);
        if (!baseResult.isSuccess()) {
            return "redirect:/user/toAdd";
        } else {
            return "redirect:/user/list";
        }
    }

    @RequestMapping("/toUpdate")
    public ModelAndView toUpdate(String id, ModelAndView modelAndView) {
        MyUser myUser = userService.findById(id);
        modelAndView.addObject("user", myUser);
        modelAndView.setViewName("user_update");
        return modelAndView;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(MyUser myUser, RedirectAttributes redirectAttributes) {
        BaseResult baseResult = userService.update(myUser);
        redirectAttributes.addFlashAttribute("baseResult", baseResult);
        if (!baseResult.isSuccess()) {
            return "redirect:/user/toUpdate?id=" + myUser.getId();
        } else {
            return "redirect:/user/list";
        }
    }

    @RequestMapping(value = "/delete")
    public String delete(String id, RedirectAttributes redirectAttributes) {
        BaseResult baseResult = userService.deleteById(id);
        redirectAttributes.addFlashAttribute("baseResult", baseResult);
        return "redirect:/user/list";
    }
}
