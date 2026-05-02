package com.qlpr.qlpr.controllers;

import com.qlpr.qlpr.entity.UserInfo;
import com.qlpr.qlpr.services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;


import java.util.Optional;

@Controller
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;
    @QueryMapping
    public Optional<UserInfo> getUserInfo(@Argument int userid)
    {
        return userInfoService.getuserinfo(userid);
    }
    @MutationMapping
    public UserInfo saveUserInfo(@Argument int userid,@Argument String firstname, @Argument String lastname,@Argument  String dob,@Argument  String bio,@Argument int following,@Argument  int followers)
    {
        return  userInfoService.saveUserInfo(userid, firstname, lastname, dob, bio, following, followers);
    }
}
