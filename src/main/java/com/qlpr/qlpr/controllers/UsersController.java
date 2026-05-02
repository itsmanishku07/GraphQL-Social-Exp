package com.qlpr.qlpr.controllers;

import com.qlpr.qlpr.entity.Users;
import com.qlpr.qlpr.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UsersController {
    @Autowired
    UserService userService;
    @QueryMapping
    public List<Users> getallusers()
    {
        return userService.getusers();
    }

    @MutationMapping
    public Users login(@Argument String username, @Argument String password)
    {
        return userService.login(username,password);
    }

    @MutationMapping
    public Users signup(@Argument String username, @Argument String password)
    {
        return userService.signup(username,password);
    }
}
