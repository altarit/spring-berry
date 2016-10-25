package com.altarit.berry.webapp.controllers;

import com.altarit.berry.model.entity.Post;
import com.altarit.berry.model.entity.User;
import com.altarit.berry.persist.service.PostService;
import com.altarit.berry.persist.service.UserService;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.constraints.NotNull;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

    private static Logger logger = LoggerFactory.getLogger(BlogController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private MessageSource messageSource;


    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public String showAllPosts(ModelMap model) {
        List<Post> posts = postService.findAllPosts();
        logger.debug("posts: " + posts.size());
        model.addAttribute("posts", posts);
        return "blog/posts";
    }

    @RequestMapping(value = "/editor", method = RequestMethod.GET)
    public String createPostPage(ModelMap model) {
        Post post = new Post();
        model.addAttribute("edit", false);
        model.addAttribute("post", post);
        return "blog/editor";
    }

    @RequestMapping(value = "/editor", method = RequestMethod.POST)
    public String createPost(ModelMap model, Post post, BindingResult result, Principal principal) {

        logger.debug("--- createPost ---");
        String username = "Aj"; //principal.getName();
        logger.debug("username: " + username);
        User user = userService.findByUsername(username);
        logger.debug("user: " + user);
        post.setUser(user);


        if (result.hasErrors()) {
            return "blog/editor";
        }
        postService.savePost(post);
        return "redirect:/blog/posts";
    }

    @RequestMapping(value = "/editor/{id}", method = RequestMethod.GET)
    public String editPostPage(ModelMap model, @PathVariable int id) {
        Post post = postService.findById(id);
        model.addAttribute("edit", true);
        model.addAttribute("post", post);
        return "blog/editor";
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public String showPostDetails(@PathVariable int id, ModelMap model) {
        Post post = postService.findById(id);
        model.addAttribute("post", post);
        return "blog/details";
    }

    @RequestMapping(value = "/editor/{id}", method = RequestMethod.POST)
    public String updatePost(ModelMap model, Post post, BindingResult result, @PathVariable int id) {




        logger.debug("--- updatePost ---");


        /*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        //String username = principal.getName();
        logger.debug("username = " + username);
        User user = userService.findByUsername(username);
        logger.debug("user = " + user);
        post.setUser(user);      */

        if (result.hasErrors()) {
            System.out.println("err: " + result);
            return "blog/editor";
        }
        postService.updatePost(post);
        return "redirect:/blog/posts/" + id;
    }




}
