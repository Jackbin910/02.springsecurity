package com.yangbin1.security;

import com.yangbin1.domain.Permission;
import com.yangbin1.domain.User;
import com.yangbin1.mapper.UserMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class MyUserDetailService implements UserDetailsService {

    private Logger logger = Logger.getLogger(MyUserDetailService.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //根据用户名查询用户信息
        User user = userMapper.findByUsername(username);
        if (user != null) {
            //根据用户名查询用户所有的权限
            List<Permission> list = userMapper.findPermissionByUsername(username);
            //存放所有用户权限
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            for (Permission perm : list) {
                GrantedAuthority authority = new SimpleGrantedAuthority(perm.getPermTag());
                authorities.add(authority);
            }
            //把所有权限给user
            user.setAuthorities(authorities);
        }
        logger.info("当前用户:" + user);

        return user;
    }
}
