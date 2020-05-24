package com.liuaq.userclient.mapper;

import com.liuaq.common.entity.base.UserEntity;
import com.liuaq.common.entity.search.UserSearchEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    UserEntity queryById(Integer id);

    UserEntity queryByAccount(String account);

    List<UserEntity> queryBySearch(UserSearchEntity userSearchEntity);

    int createUser(UserEntity userEntity);

    int deleteById(Integer id);
}
