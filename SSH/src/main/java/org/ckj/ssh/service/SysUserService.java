package org.ckj.ssh.service;

import org.ckj.ssh.pojo.dto.SysUserDTO;

public interface SysUserService {
    /**
     * @description: 登录操作
     * @author: ckj
     * @date: 2024/11/8 上午11:34
     * @param: [username, password]
     * @return: boolean
    **/
    boolean login(String username, String password);

    /**
     * @description: 根据Id获取用户信息
     * @author: ckj
     * @date: 2024/11/8 下午1:44
     * @param: [id]
     * @return: org.ckj.ssh.pojo.dto.SysUserDTO
    **/
    SysUserDTO info(Integer id);
}
