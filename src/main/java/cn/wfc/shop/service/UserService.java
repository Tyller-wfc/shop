package cn.wfc.shop.service;

import cn.wfc.shop.entity.BaseResult;
import cn.wfc.shop.entity.MyUser;

import java.util.List;

public interface UserService {
    MyUser findUserByName(String name);

    List<MyUser> findAll();

    BaseResult add(MyUser myUser);
}
