package org.ckj.ssm.service;

import org.ckj.ssm.pojo.dto.SysUserDTO;

public interface SysUserService {
    boolean login(String username, String password);

    String getAll(SysUserDTO sysUserDTO);
}
