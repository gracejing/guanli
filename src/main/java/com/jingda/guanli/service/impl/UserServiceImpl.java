package com.jingda.guanli.service.impl;

import com.jingda.guanli.dao.UserInfoMapper;
import com.jingda.guanli.model.UserInfo;
import com.jingda.guanli.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserServiceImpl  implements UserService {
    @Autowired
    private UserInfoMapper userDao;//这里可能会报错，但是并不会影响

    @Override
    public List findAllUser(){
        return  userDao.findAllUser();
    }

    public boolean inserUser(String username, String password,String sex,String phone) {
        userDao.inserUser(username,password,sex,phone);
        return true;
    }

    public UserInfo selectUser(String username, String password) {

        System.out.println(username+" "+username);
        return userDao.selectUser(username,password);

    }

    public UserInfo selectPerson(String username, String password,String sex,String phone) {

        System.out.println(username+" "+password);
        return userDao.selectUser(username,password);

    }

}
