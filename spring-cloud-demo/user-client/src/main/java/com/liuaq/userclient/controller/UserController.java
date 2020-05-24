package com.liuaq.userclient.controller;

import com.liuaq.common.annotation.ControllerLog;
import com.liuaq.common.aspect.LogAspect;
import com.liuaq.common.base.BaseResult;
import com.liuaq.common.entity.base.UserEntity;
import com.liuaq.common.entity.search.UserSearchEntity;
import com.liuaq.userclient.service.UserService;
import com.netflix.client.http.HttpRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

@Aspect
@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController implements Serializable {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public BaseResult<UserEntity> getUserByAccount(@RequestParam("account") String account) {
        UserEntity userEntity = userService.queryByAccount(account);
        return BaseResult.success(userEntity);
    }


    @ControllerLog(requestMethod = "GET")
    @RequestMapping(value = "/get/{id:\\d+}", method = RequestMethod.GET)
    public BaseResult<UserEntity> getUserById(@PathVariable("id") Integer id) {
        UserEntity userEntity = userService.queryById(id);
        return BaseResult.success(userEntity);
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public BaseResult queryBySearch(UserSearchEntity userSearchEntity) {
        List<UserEntity> userEntityList = userService.queryBySearch(userSearchEntity);
        return BaseResult.success(userEntityList);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResult addUser(@RequestBody UserEntity userEntity) {
        userService.createUser(userEntity);
        return BaseResult.success(userEntity.getId());
    }

}
