package org.ckj.springsecurity;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.ckj.springsecurity.mapper.UserMapper;
import org.ckj.springsecurity.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringSecurityApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUserName,"admin");
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }

}
