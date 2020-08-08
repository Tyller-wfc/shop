package cn.wfc.shop.mapper;

import cn.wfc.shop.entity.MyUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyUserMapper {
    MyUser findUserByEmail(String email);

    MyUser findById(String id);

    List<MyUser> findAll();

    List<MyUser> findByKey(String key);

    int insert(@Param("myUser") MyUser myUser);

    int updateById(@Param("myUser") MyUser myUser);

    List<MyUser> findByExample(@Param("example") MyUser example);

    int deleteById(String id);
}
