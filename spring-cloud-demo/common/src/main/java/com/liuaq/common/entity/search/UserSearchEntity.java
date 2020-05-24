package com.liuaq.common.entity.search;

import lombok.Data;

import java.util.Date;

@Data
public class UserSearchEntity {

    private int id;

    private String userId;

    private String account;

    private String name;

    private int sex;

    private Date birthday;

    private String createAccount;

    private Date beginCreateTime;

    private Date endCreateTime;
}
