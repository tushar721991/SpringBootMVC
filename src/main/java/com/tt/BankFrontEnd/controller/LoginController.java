package com.tt.BankFrontEnd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @RequestMapping(value = "/hello")
//    @ResponseBody
    public String sayHello() {
        return "login";
    }
    
    @RequestMapping(value="/test")
//    @ResponseBody
    public ModelAndView test() {
    	return new ModelAndView("login");
    }

}