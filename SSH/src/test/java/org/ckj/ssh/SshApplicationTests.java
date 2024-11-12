package org.ckj.ssh;

import org.ckj.ssh.pojo.entity.SysUser;
import org.ckj.ssh.repository.SysUserRepository;
import org.ckj.ssh.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.Instant;
import java.util.Date;

@SpringBootTest
class SshApplicationTests {
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysUserRepository sysUserRepository;
    @Test
    void contextLoads() {
        //分页查询
        Pageable pageable = PageRequest.of(1, 1);
        System.out.println(sysUserService.getAll(pageable));
    }

    @Test
    void testLogin(){
//        SysUser sysUser =
//                SysUser.builder()
//                .username("admin")
//                .password("123456")
//                .createdAt(new Date())
//                .updatedAt(new Date())
//                .deletedAt(new Date())
//                .build();
        System.out.println(sysUserRepository.findById(1L));
//        sysUserRepository.save(sysUser);

        Instant now = Instant.now();
        System.out.println(now);
    }

}
