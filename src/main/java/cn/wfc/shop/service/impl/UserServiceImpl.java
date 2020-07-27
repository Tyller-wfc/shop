package cn.wfc.shop.service.impl;

import cn.wfc.shop.entity.MyUser;
import cn.wfc.shop.service.UserService;
import cn.wfc.shop.mapper.MyUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MyUserMapper myUserMapper;

    @Override
    public MyUser findUserByName(String name) {
        return myUserMapper.findUserByEmail(name);
    }

    @Override
    public List<MyUser> findAll() {
        return myUserMapper.findAll();
    }

    @Override
    public MyUser add(MyUser myUser) {
        myUser.setCreated(new Date());
        myUser.setUpdated(new Date());
        myUserMapper.insert(myUser);
        return myUser;
    }
}
