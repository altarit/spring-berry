package com.altarit.berry.webapp.controllers;

import com.altarit.berry.model.entity.User;
import com.altarit.berry.model.entity.UserProfile;
import com.altarit.berry.persist.service.UserProfileService;
import com.altarit.berry.persist.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value= {"/users"}, method = RequestMethod.GET)
    public String getUserList(ModelMap model) {
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users/index";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String createNewUserPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        return "users/registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String createNewUser(ModelMap model, @Valid User user, BindingResult result) {
        System.out.println(user);
        if (result.hasErrors()) {
            System.out.println("err: " + result);
            return "users/registration";
        }
        userService.saveUser(user);
        System.out.println(user);
        return "redirect:/users";
    }


    @RequestMapping(value = "/registration/{username}", method = RequestMethod.GET)
    public String updateUserPage(@PathVariable String username, Model model) {
        System.out.println("updateUserPage: " + username);
        User user = userService.findByUsername(username);
        //user = new User();
        user.setUsername(username);
        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        return "users/registration";
    }


    @RequestMapping(value = "/registration/{username}", method = RequestMethod.POST)
    public String updateUser(Model model, @Valid User user, BindingResult result) {
        System.out.println(user);
        if (result.hasErrors()) {
            System.out.println("err: " + result);
            return "users/registration";
        }
        userService.updateUser(user);
        return "redirect:/users";
    }



    @RequestMapping(value = "/deletion/{username}", method = RequestMethod.GET)
    public String deleteUserPage(Model model, @PathVariable String username) {
        logger.debug("username: {}", username);
        System.out.println(username);
        model.addAttribute("username", username);
        return "users/deletion";
    }


    @RequestMapping(value = "/deletion/{username}", method = RequestMethod.POST)
    public String deleteUser(Model model, @PathVariable String username) {
        System.out.println(username);
        userService.deleteUserByUsername(username);
        return "redirect:/users";
    }

    @ModelAttribute("roles")
    public List<UserProfile> initializeProfiles() {
        return userProfileService.findAll();
    }


}
