package org.ckj.ssm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import org.ckj.ssm.mapper.SysUserMapper;
import org.ckj.ssm.pojo.entity.SysUser;
import org.ckj.ssm.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * @Author: ckj
 * @CreateTime: 2024-11-08  14:27
 * @Description: SysUser业务层
 * @Version: 1.0
 */
@Service
@RequiredArgsConstructor
public class SysUserServiceImpl implements SysUserService {
    private final SysUserMapper sysUserMapper;

    @Override
    public boolean login(String username, String password) {
        QueryWrapper<SysUser> query = new QueryWrapper<>();
        query.eq("username", username).eq("password", password);
        SysUser sysUser = sysUserMapper.selectOne(query);
        if (sysUser != null) {
            return true;
        }
        return false;
    }
}
