package com.altarit.berry.webapp.controllers;

import com.altarit.berry.model.entity.User;
import com.altarit.berry.persist.service.UserService;
import com.altarit.berry.webapp.configuration.AppConfig;
import com.altarit.berry.webapp.configuration.AppInitializer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

//@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest {

    private final Logger logger = LoggerFactory.getLogger(UserControllerTest.class);

    @Mock
    UserService userService;

    @InjectMocks
    UserController userController;

    @Spy
    ModelMap model;

    @Mock
    BindingResult result;

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        logger.debug("setup test");
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void reset() {
        logger.debug("reset test");
    }

    @Test
    public void getUserList_test() {
        List<User> expectedUsers = Arrays.asList(new User(), new User(), new User());
        when(userService.findAllUsers()).thenReturn(expectedUsers);
        ModelMap model = new ModelMap();
        String viewName = userController.getUserList(model);

        assertEquals("users/index", viewName);
        assertSame(expectedUsers, model.get("users"));
    }

    @Test
    public void createNewUser_successTest() {
        User user = new User();
        doNothing().when(userService).saveUser(any(User.class));
        when(result.hasErrors()).thenReturn(false);
        String viewName = userController.createNewUser(model, user, result);
        assertEquals("redirect:/users", viewName);
    }


    @Test
    public void createNewUser_failedTest() {
        User user = new User();
        doNothing().when(userService).saveUser(any(User.class));
        when(result.hasErrors()).thenReturn(true);
        String viewName = userController.createNewUser(model, user, result);
        assertEquals("users/registration", viewName);
    }

}
