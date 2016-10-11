package com.altarit.berry.webapp.controllers;

import com.altarit.berry.model.entity.User;
import com.altarit.berry.persist.service.UserProfileService;
import com.altarit.berry.persist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/users/")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserProfileService userProfileService;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String listUsers(ModelMap model) {
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users/index";
    }

}
