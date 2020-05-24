package com.liuaq.userclient.service;

import com.liuaq.common.entity.base.UserEntity;
import com.liuaq.common.entity.search.UserSearchEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> queryUsers(UserEntity userEntity);

    UserEntity queryById(Integer id);

    UserEntity queryByAccount(String account);

    List<UserEntity> queryBySearch(UserSearchEntity userSearchEntity);

    int createUser(UserEntity userEntity);

    int deleteById(Integer id);
}
