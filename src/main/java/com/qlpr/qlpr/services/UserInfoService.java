package com.qlpr.qlpr.services;

import com.qlpr.qlpr.entity.UserInfo;
import com.qlpr.qlpr.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoService
{
    @Autowired
    UserInfoRepository userInfoRepository;
    public Optional<UserInfo> getuserinfo(int id)
    {
        return userInfoRepository.findById(id);
    }

    public UserInfo saveUserInfo(int id,String firstname, String lastname, String dob, String bio, int following, int followers)
    {
        UserInfo existing = userInfoRepository.findById(id).orElseThrow(()-> new RuntimeException("UserNot Found"));
        existing.setFirstname(firstname);
        existing.setLastname(lastname);
        existing.setDob(dob);
        existing.setBio(bio);
        existing.setFollowing(following);
        existing.setFollowers(followers);
        userInfoRepository.save(existing);
        return existing;
    }
}


