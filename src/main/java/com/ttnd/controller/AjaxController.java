package com.ttnd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam String email){
        return "ajax controller "+email+" oye";
    }
}
