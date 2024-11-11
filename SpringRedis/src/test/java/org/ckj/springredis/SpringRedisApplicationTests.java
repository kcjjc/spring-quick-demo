package org.ckj.springredis;

import org.ckj.springredis.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringRedisApplicationTests {

    @Autowired
    private SysUserService sysUserService;
    @Test
    void contextLoads() {
        System.out.println(sysUserService.info(1));
    }

}
