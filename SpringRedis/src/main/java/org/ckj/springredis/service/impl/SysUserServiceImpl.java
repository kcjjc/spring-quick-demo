package org.ckj.springredis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import org.ckj.springredis.mapper.SysUserMapper;
import org.ckj.springredis.pojo.dto.SysUserDTO;
import org.ckj.springredis.pojo.entity.SysUser;
import org.ckj.springredis.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * @Author: ckj
 * @CreateTime: 2024-11-11  10:49
 * @Description:
 * @Version: 1.0
 */
@Service
@RequiredArgsConstructor
public class SysUserServiceImpl implements SysUserService {
    private final SysUserMapper sysUserMapper;

    @Override
    public SysUserDTO info(Integer id) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", id);
        SysUser sysUser = sysUserMapper.selectOne(queryWrapper);
        return SysUserDTO.builder()
                .userId(sysUser.getUserId())
                .username(sysUser.getUsername())
                .password(sysUser.getPassword())
                .nickName(sysUser.getNickName())
                .phone(sysUser.getPhone())
                .roleId(sysUser.getRoleId())
                .salt(sysUser.getSalt())
                .avatar(sysUser.getAvatar())
                .sex(sysUser.getSex())
                .email(sysUser.getEmail())
                .deptId(sysUser.getDeptId())
                .postId(sysUser.getPostId())
                .remark(sysUser.getRemark())
                .status(sysUser.getStatus())
                .createBy(sysUser.getCreateBy())
                .updateBy(sysUser.getUpdateBy())
                .createdAt(sysUser.getCreatedAt())
                .updatedAt(sysUser.getUpdatedAt())
                .deletedAt(sysUser.getDeletedAt())
                .build();
    }
}
