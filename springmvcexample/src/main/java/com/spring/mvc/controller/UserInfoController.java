package com.spring.mvc.controller;

import com.spring.mvc.model.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by renqun.yuan on 2015/11/27.
 */
@RequestMapping("/user")
@Controller
public class UserInfoController {
    @RequestMapping("/queryUser")
    @ResponseBody
    public UserInfo queryUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId("2");
        userInfo.setName("renqun.yuan");
        return userInfo;
    }
}
