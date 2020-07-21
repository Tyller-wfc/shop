package cn.wfc.shop.service;

import cn.wfc.shop.entity.MyUser;

public interface UserService {
    MyUser findUserByName(String name);
}
