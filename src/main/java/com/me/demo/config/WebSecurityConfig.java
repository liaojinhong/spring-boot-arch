package com.me.demo.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

import com.me.demo.service.CustomUserDetailsService;

/**
 * Spring Security 配置
 * 
 * @author ljh
 *
 */
@SuppressWarnings("deprecation")
@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)//开启security注解
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    /* 
     * 请求拦截配置和调转配置
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	// 关闭防跨域攻击功能
    	// http.csrf().disable();  
    	
        //允许所有用户访问"/"和"/home"
        http.authorizeRequests()
                .antMatchers("/*", "/home","/ws/*").permitAll()
                //其他地址的访问均需验证权限
                .anyRequest().authenticated()
                .and()
                .formLogin()
                //指定登录页是"/login"
                .loginPage("/login")
                .defaultSuccessUrl("/hello")//登录成功后默认跳转到"/hello"
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/home")//退出登录后的默认url是"/home"
                .permitAll();

//        //其他地址的访问均需验证权限
//        .anyRequest().permitAll();

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //auth.userDetailsService(customUserDetailsService()).passwordEncoder(passwordEncoder());  // 密码MD5加密
    	auth.userDetailsService(customUserDetailsService());  // 密码不加密
    }

    /**
     * 设置用户密码的加密方式为MD5加密
     * @return
     */
    @Bean
    public Md5PasswordEncoder passwordEncoder() {
        return new Md5PasswordEncoder();

    }

    /**
     * 自定义UserDetailsService，从数据库中读取用户信息
     * @return
     */
    @Bean
    public CustomUserDetailsService customUserDetailsService(){
        return new CustomUserDetailsService();
    }

}