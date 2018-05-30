package com.me.demo.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.me.demo.entity.SRole;
import com.me.demo.entity.SUser;

/**
 * 用户安全对象，实现UserDetails接口
 * 
 * @author ljh
 *
 */
public class SecurityUser extends SUser implements UserDetails {

    private static final long serialVersionUID = 1L;

    /**
     * 构造方法，初始化一个用户安全对象
     * @param suser
     */
    public SecurityUser(SUser suser) {
        if (suser != null)
        {
            this.setId(suser.getId());
            this.setName(suser.getName());
            this.setEmail(suser.getEmail());
            this.setPassword(suser.getPassword());
            this.setDob(suser.getDob());
            this.setSRoles(suser.getSRoles());
        }

    }


    /* 
     * 权限相关处理
     */
    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        Set<SRole> userRoles = this.getSRoles();
        if (userRoles != null)
        {
            for (SRole role : userRoles) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
                authorities.add(authority);
            }
        }
        return authorities;
    }


    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getEmail();
    }

    /* 
     * 账户是否过期
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /* 
     * 账户是否被锁
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /* 
     * 密码是否过期
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /* 
     * 是否可用（开关）
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

}