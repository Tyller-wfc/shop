package cn.wfc.shop.service.impl;

import cn.wfc.shop.entity.User;
import cn.wfc.shop.service.UserService;
import cn.wfc.shop.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByName(String name) {
        return userMapper.findUserByName(name);
    }
}
