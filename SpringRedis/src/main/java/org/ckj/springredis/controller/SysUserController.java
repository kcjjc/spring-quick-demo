package org.ckj.springredis.controller;

import lombok.RequiredArgsConstructor;
import org.ckj.springredis.pojo.dto.SysUserDTO;
import org.ckj.springredis.service.SysUserService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author: ckj
 * @CreateTime: 2024-11-11  10:49
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("sysuser")
@RequiredArgsConstructor
public class SysUserController {
    private final SysUserService sysUserService;
    private final RedisTemplate<String,SysUserDTO> redisTemplate;

    @GetMapping("info")
    public SysUserDTO info(Integer id) {
        SysUserDTO sysUserDTO = sysUserService.info(id);
        //插入
        redisTemplate.opsForValue().set("test",sysUserDTO,10, TimeUnit.SECONDS);
        return sysUserDTO;
    }

    @GetMapping("get")
    public SysUserDTO get() {
        //取出
        return redisTemplate.opsForValue().get("test");
    }
}
