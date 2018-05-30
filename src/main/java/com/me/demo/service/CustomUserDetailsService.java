package com.me.demo.service;


import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.me.demo.dto.SecurityUser;
import com.me.demo.entity.SUser;

/**
 * 用户登录验证，实现UserDetailsService接口
 * 
 * @author ljh
 *
 */
public class CustomUserDetailsService implements UserDetailsService {
	
    @Autowired
    private SUserService suserService;

    /* 
     * loadUserByUsername 实现接口定义方法
     * 
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //SUser对应数据库中的用户表，是最终存储用户和密码的表，可自定义
        //本例使用SUser中的email作为用户名:
        //SUser user = suserService.findUserByEmail(userName);  // 377890166@qq.com  123456
        SUser user = suserService.findUserByUserName(userName); // liaojinhong   123456

        if (user == null) {

            throw new UsernameNotFoundException("UserName " + userName + " not found");

        }

        // SecurityUser实现UserDetails并将SUser的Email映射为username
        SecurityUser securityUser = new SecurityUser(user);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_user"));
        return securityUser; 

    }

}
