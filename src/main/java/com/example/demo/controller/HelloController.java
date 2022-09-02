package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class HelloController {

    @RequestMapping("/say")
    @ResponseBody
    public String hello(){
        return "EveryBody Hello!";
    }
}
