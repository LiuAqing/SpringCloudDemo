package com.liuaq.userclient.service.impl;

import com.liuaq.common.entity.base.UserEntity;
import com.liuaq.common.entity.search.UserSearchEntity;
import com.liuaq.userclient.mapper.UserMapper;
import com.liuaq.userclient.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserEntity> queryUsers(UserEntity userEntity) {
        return null;
    }

    @Override
    public UserEntity queryById(Integer id) {
        return userMapper.queryById(id);
    }

    @Override
    public UserEntity queryByAccount(String account) {
        return userMapper.queryByAccount(account);
    }

    @Override
    public List<UserEntity> queryBySearch(UserSearchEntity userSearchEntity) {
        return userMapper.queryBySearch(userSearchEntity);
    }

    @Override
    public int createUser(UserEntity userEntity) {
        return userMapper.createUser(userEntity);
    }

    @Override
    public int deleteById(Integer id) {
        return userMapper.deleteById(id);
    }
}
