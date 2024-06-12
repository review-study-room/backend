package com.fudan.studyroom.controller;

import com.fudan.studyroom.entity.User;
import com.fudan.studyroom.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
@RequestMapping("/api/users")
@Controller
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @ResponseBody
    public Integer registerUser(
            @RequestParam("userName") String userName,
            @RequestParam("passWord") String passWord
            ) {
        User user = new User();
        user.setUsername(userName);
        user.setPassword(passWord);

        return userService.insert(user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public boolean loginUser(
            @RequestParam("userName") String userName,
            @RequestParam("passWord") String passWord
            ) {
        return !userService.selectByNameAndPassword(userName, passWord).isEmpty();
    }


    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(
            @PathVariable("username") String username
            ) {
        return userService.selectByName(username);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public Integer test(
    ) {
        return 1;
    }
}
