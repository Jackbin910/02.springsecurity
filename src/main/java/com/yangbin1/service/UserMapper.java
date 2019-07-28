package com.yangbin1.service;

import com.yangbin1.domain.Permission;
import com.yangbin1.domain.User;

import java.util.List;

public interface UserMapper {

    /**
     * 查询当前用户对象
     * @param username
     * @return
     */
    public User findByUsername(String username);

    /**
     * 查询当前用户的权限
     * @param username
     * @return
     */
    public List<Permission> findPermissionByUsername(String username);
}
