package cn.wfc.shop.service;

import cn.wfc.shop.entity.User;

public interface UserService {
    User findUserByName(String name);
}
