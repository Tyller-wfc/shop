package cn.wfc.shop.mapper;

import cn.wfc.shop.entity.MyUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyUserMapper {
    MyUser findUserByEmail(String email);

    List<MyUser> findAll();
}
