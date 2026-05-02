package com.qlpr.qlpr.services;

import com.qlpr.qlpr.entity.UserInfo;
import com.qlpr.qlpr.entity.Users;
import com.qlpr.qlpr.repository.UserInfoRepository;
import com.qlpr.qlpr.repository.UsersRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    UserInfoRepository userInfoRepository;
    public List<Users> getusers()
    {
        return usersRepository.findAll();
    }

    public Users signup(String username, String password)
    {
        Users users = new Users();
        users.setUsername(username);
        users.setPassword(password);
        users.setJoindate(new Date().toString());
        usersRepository.save(users);

        UserInfo userInfo = new UserInfo();
        userInfo.setUserid(users.getUserid());
        userInfoRepository.save(userInfo);

        return users;

    }

    public Users login(String username, String password)
    {
        Users existing = usersRepository.findByUsername(username);

        if(existing != null && existing.getPassword().equals(password))
        {
            return existing;
        }
        return null;
    }

}
