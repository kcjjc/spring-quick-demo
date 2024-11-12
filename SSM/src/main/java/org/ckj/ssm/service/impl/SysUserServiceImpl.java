package org.ckj.ssm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import org.ckj.ssm.mapper.SysUserMapper;
import org.ckj.ssm.pojo.dto.SysUserDTO;
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

    /**
     * @description:
     * @author: ckj
     * @date: 2024/11/12 上午10:57
     * @param: [username 账户,
     *          password 密码]
     * @return: boolean
    **/
    @Override
    public boolean login(String username, String password) {
        QueryWrapper<SysUser> query = new QueryWrapper<>();
        query.eq("username", username).eq("password", password);
        SysUser sysUser = sysUserMapper.selectOne(query);
        return sysUser != null;
    }

    /**
     * @description: 查询信息
     * @author: ckj
     * @date: 2024/11/12 上午10:57
     * @param: [sysUserDTO]
     * @return: java.lang.String
    **/
    @Override
    public String getAll(SysUserDTO sysUserDTO) {
        QueryWrapper<SysUser> query = new QueryWrapper<>();
        sysUserMapper.selectList(query);
        return "success";
    }
}
