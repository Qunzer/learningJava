package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by renqun.yuan on 2015/11/27.
 */
@Controller
@RequestMapping("/users")
public class ModelAndViewController {

    @RequestMapping("/queryUser")
    public ModelAndView queryUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("queryUser");
        return modelAndView;
    }
}

