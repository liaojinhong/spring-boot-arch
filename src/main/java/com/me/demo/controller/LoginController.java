package com.me.demo.controller;

import javax.annotation.Resource;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.demo.service.SUserService;

@Controller
public class LoginController {

    @Resource
    private SUserService sUserService;

    @RequestMapping("/home")
    public String home() {
        return "home";

    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
    
    /**
     * @PreAuthorize 角色权限控制，默认是 ROLE_开头的，所以数据库中配置角色应该是： ROLE_admin
     * @return
     */
    @PreAuthorize("hasRole('admin')")
    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public String toAdmin(){
        return "helloAdmin";
    }
    
    /**
     * @PreAuthorize 角色权限控制，默认是 ROLE_开头的，所以数据库中配置角色应该是： ROLE_user
     * @return
     */
    @PreAuthorize("hasRole('user')")
	@RequestMapping(value = "/user",method = RequestMethod.GET)
	public String toUser(){
	    return "helloUser";
    }

    @RequestMapping("/")
    public String root() {
        return "index";
    }

    @RequestMapping("/403")
    public String error(){
        return "403";
    }
}
