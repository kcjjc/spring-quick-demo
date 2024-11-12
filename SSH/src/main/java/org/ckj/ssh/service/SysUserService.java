package org.ckj.ssh.service;

import org.ckj.ssh.pojo.dto.SysUserDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SysUserService {
    /**
     * @description: 登录操作
     * @author: ckj
     * @date: 2024/11/8 上午11:34
     * @param: [username 账户,
     *          password 密码]
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

    /**
     * @description: 获取全部sys_user
     * @author: ckj
     * @date: 2024/11/9 下午3:56
     * @param: [pageable]
     * @return: java.util.List<org.ckj.ssh.pojo.dto.SysUserDTO>
    **/
    List<SysUserDTO> getAll(Pageable pageable);

    /**
     * @description: 注册用户
     * @author: ckj
     * @date: 2024/11/12 上午10:19
     * @param: [sysUserDTO]
     * @return: void
    **/
    void register(SysUserDTO sysUserDTO);
}
