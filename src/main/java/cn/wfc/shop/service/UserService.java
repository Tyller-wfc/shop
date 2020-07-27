package cn.wfc.shop.service;

import cn.wfc.shop.entity.MyUser;

import java.util.List;

public interface UserService {
    MyUser findUserByName(String name);

    List<MyUser> findAll();

    MyUser add(MyUser myUser);
}
