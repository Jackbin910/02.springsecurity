package com.yangbin1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/userLogin")
    public String login(){
        return "login";
    }

    @RequestMapping("/error")
    public String error(){
        return "error";
    }
}
