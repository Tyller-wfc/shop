package cn.wfc.shop;

import cn.wfc.shop.entity.MyUser;
import cn.wfc.shop.mapper.MyUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private MyUserMapper myUserMapper;

    @Test
    void contextLoads() {
        MyUser example = new MyUser();
        example.setUsername("wfc");
        List<MyUser> byExample = myUserMapper.findByExample(example);
        System.out.println(byExample);
    }

}
