package com.xiaofei.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by xiaofei
 * Created at 2017/4/23.
 */
@Controller
@ApiIgnore
public class HelloController {


    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello world "+System.currentTimeMillis();
     }

    @RequestMapping("/show")
    public ModelAndView show(){
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("name","XiaoFei");
        return modelAndView;
    }
}
