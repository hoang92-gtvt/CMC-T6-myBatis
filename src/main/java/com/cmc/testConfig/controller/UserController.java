package com.cmc.testConfig.controller;

import com.cmc.testConfig.model.User;
import com.cmc.testConfig.serivce.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired

    private IUserService userService ;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("home");
        return mav;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView  listUsers1() {
        ModelAndView mav = new ModelAndView("list");
        List<User> userList = userService.getAllUsers();
        mav.addObject("list", userList);

        return mav;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView  findOneUser(@PathVariable("id") long id) {
        ModelAndView mav = new ModelAndView("detail");
        User user = userService.getUser(id);
        mav.addObject("user", user);

        return mav;
    }




}
