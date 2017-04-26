package com.xiaofei.web;

import com.xiaofei.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by xiaofei
 * Created at 2017/4/23.
 */
@Controller
@ApiIgnore
@Slf4j
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

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/dologin" ,method = RequestMethod.POST)
    public String doLogin(@ModelAttribute("form") User user){
        log.info("user"+user);
       return "index";
    }


}
