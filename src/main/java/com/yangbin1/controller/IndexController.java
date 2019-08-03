package com.yangbin1.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/userLogin")
    public String login(Model model) {
        //获取登录后的用户:UserDetail对象
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal != null) {
            if (principal instanceof UserDetails) {
                UserDetails userDetails = (UserDetails) principal;
                String username = userDetails.getUsername();
                model.addAttribute("username",username);
            }
        }
        return "login";
    }

    @RequestMapping("/error")
    public String error() {
        return "error";
    }

    @RequestMapping("/imageCode")
    public String imageCode() {
        return "imageCode";
    }
}
