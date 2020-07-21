package cn.wfc.shop.mapper;

import cn.wfc.shop.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User findUserByName(String name);
}
