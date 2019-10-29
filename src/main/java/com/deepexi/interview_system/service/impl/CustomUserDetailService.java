package com.deepexi.interview_system.service.impl;

import com.deepexi.interview_system.model.User;
import com.deepexi.interview_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserService userService;
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user1 = userService.findUserByName(name);
        if (user1 == null){
            throw new UsernameNotFoundException("用户不存在！");
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();

        org.springframework.security.core.userdetails.User user =
                new org.springframework.security.core.userdetails.User(name,user1.getPassword(),authorities);
        return user;
    }
}
