package org.ckj.springredis.service;

import org.ckj.springredis.pojo.dto.SysUserDTO;

/**
 * @Author: ckj
 * @CreateTime: 2024-11-11  10:48
 * @Description: TODO
 * @Version: 1.0
 */
public interface SysUserService {
    SysUserDTO info(Integer id);
}
