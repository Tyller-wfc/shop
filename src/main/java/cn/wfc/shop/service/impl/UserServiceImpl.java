package cn.wfc.shop.service.impl;

import cn.wfc.shop.entity.BaseResult;
import cn.wfc.shop.entity.MyUser;
import cn.wfc.shop.service.UserService;
import cn.wfc.shop.mapper.MyUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;
import sun.swing.StringUIClientPropertyKey;

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
    public MyUser findById(String id) {
        return myUserMapper.findById(id);
    }

    @Override
    public List<MyUser> findAll() {
        return myUserMapper.findAll();
    }

    @Override
    public BaseResult add(MyUser myUser) {
        myUser.setCreated(new Date());
        myUser.setUpdated(new Date());
        BaseResult baseResult = checkUser(myUser);
        if (baseResult.isSuccess()) {
            //验证密码不能为空
            if (StringUtils.isEmpty(myUser.getPassword())) {
                return BaseResult.fail("密码为空");
            }
            myUserMapper.insert(myUser);
            baseResult = BaseResult.success(myUser);
            baseResult.setMsg("用户添加成功");
        }
        return baseResult;
    }

    @Override
    public BaseResult update(MyUser myUser) {
        myUser.setUpdated(new Date());
        BaseResult baseResult = checkUser(myUser);
        if (baseResult.isSuccess()) {
            myUserMapper.updateById(myUser);
            baseResult = BaseResult.success(myUser);
            baseResult.setMsg("用户修改成功");
        }
        return baseResult;
    }

    @Override
    public BaseResult deleteById(String id) {
        int i = myUserMapper.deleteById(id);
        if (i == 1) {
            BaseResult baseResult = new BaseResult();
            baseResult.setSuccess(true);
            baseResult.setMsg("删除成功");
            return baseResult;
        }
        return BaseResult.fail("删除失败");
    }

    public BaseResult checkUser(MyUser myUser) {
        String username = myUser.getUsername();
        String email = myUser.getEmail();
        String phone = myUser.getPhone();
        //判断是否为空，不允许为空
        if (StringUtils.isEmpty(username)) {
            return BaseResult.fail("用户名为空");
        }
        if (StringUtils.isEmpty(phone)) {
            return BaseResult.fail("电话为空");
        }
        if (StringUtils.isEmpty(email)) {
            return BaseResult.fail("邮箱为空");
        }
        Integer id = myUser.getId();
        //判断是新增还是修改
        if (id == null) {
            MyUser example = new MyUser();
            //判断是否重复，重复不允许添加，判断项有电话，邮箱，用户名
            example.setUsername(username);
            List<MyUser> users = myUserMapper.findByExample(example);
            if (users.size() > 0) {
                return BaseResult.fail("用户名重复");
            }
            example = new MyUser();
            example.setPhone(phone);
            users = myUserMapper.findByExample(example);
            if (users.size() > 0) {
                return BaseResult.fail("电话重复");
            }
            example = new MyUser();
            example.setEmail(email);
            users = myUserMapper.findByExample(example);
            if (users.size() > 0) {
                return BaseResult.fail("邮箱重复");
            }
        } else {
            MyUser example = new MyUser();
            //判断是否重复，重复不允许添加，判断项有电话，邮箱，用户名
            example.setUsername(username);
            List<MyUser> users = myUserMapper.findByExample(example);
            if (users.size() > 0 && users.get(0).getId() != id) {
                return BaseResult.fail("该用户名已存在");
            }
            example = new MyUser();
            example.setPhone(phone);
            users = myUserMapper.findByExample(example);
            if (users.size() > 0 && users.get(0).getId() != id) {
                return BaseResult.fail("该电话号码已存在");
            }
            example = new MyUser();
            example.setEmail(email);
            users = myUserMapper.findByExample(example);
            if (users.size() > 0 && users.get(0).getId() != id) {
                return BaseResult.fail("该邮箱账号已存在");
            }
        }
        return BaseResult.success("成功");
    }
}
