package com.jingda.guanli.service;

import com.jingda.guanli.model.UserInfo;

import java.util.List;

public interface UserService {
    List findAllUser();
    public boolean inserUser(String username,String password,String sex,String phone);

    public UserInfo selectUser(String username, String password);
    public UserInfo selectPerson(String username, String password,String sex,String phone);
}
