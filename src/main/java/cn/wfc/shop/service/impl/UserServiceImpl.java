package cn.wfc.shop.service.impl;

import cn.wfc.shop.entity.BaseResult;
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
    public BaseResult add(MyUser myUser) {
        myUser.setCreated(new Date());
        myUser.setUpdated(new Date());
        //判断是否重复，重复不允许添加，判断项有电话，邮箱，用户名
        String username = myUser.getUsername();
        String email = myUser.getEmail();
        String phone = myUser.getPhone();
        MyUser example = new MyUser();
        example.setUsername(username);
        List<MyUser> users = myUserMapper.findByExample(example);
        if (users.size() > 0) {
            return BaseResult.fail("用户名重复");
        }
        example = new MyUser();
        example.setEmail(email);
        users = myUserMapper.findByExample(example);
        if (users.size() > 0) {
            return BaseResult.fail("邮箱重复");
        }
        example = new MyUser();
        example.setPhone(phone);
        users = myUserMapper.findByExample(example);
        if (users.size() > 0) {
            return BaseResult.fail("电话重复");
        }
        myUserMapper.insert(myUser);
        return BaseResult.success(myUser);
    }
}
