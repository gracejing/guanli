package com.jingda.guanli.controller;

import com.jingda.guanli.model.UserInfo;
import com.jingda.guanli.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = {"/user"})
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/findAll"},produces = {"application/json;charset=UTF-8"},method = RequestMethod.GET)
    public List getAllUsers() {
        List list = userService.findAllUser();
        return list;
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/regist")
    public String regist(){
        return "register";
    }
    @RequestMapping("/dologin")
    //@ResponseBody
    public String doLogin(UserInfo user, Model model,Map<String,Object> map){
        System.out.println();
        UserInfo user1 = userService.selectUser(user.getName(),user.getPassword());
        System.out.print(user1);
        if(user1==null){
            map.put("msg", "密码或账号错误!");
            return "fail";
        }else {
            model.addAttribute("msg",user1.getName()+"&&&&"+user1.getPassword());
            //map.put("msg", user1);
            return "success";
        }
    }
    @RequestMapping("/doregist")
    public String doRegist(UserInfo user,Map<String,Object> map) {
        System.out.println(user.getName());
        userService.inserUser(user.getName(), user.getPassword(),user.getSex(),user.getPhone());
        map.put("msg","注册成功");
        return "login";
    }

    @RequestMapping("/show")
    public ModelAndView showperson() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        modelAndView.addObject("msg", "");
        return modelAndView;
    }

}
