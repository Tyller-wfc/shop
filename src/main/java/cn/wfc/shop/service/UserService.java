package cn.wfc.shop.service;

import cn.wfc.shop.entity.BaseResult;
import cn.wfc.shop.entity.MyUser;

import java.util.List;

public interface UserService {
    MyUser findUserByName(String name);

    MyUser findById(String id);

    List<MyUser> findAll();

    List<MyUser> findByKey(String key);

    BaseResult add(MyUser myUser);

    BaseResult update(MyUser myUser);

    BaseResult deleteById(String id);
}
