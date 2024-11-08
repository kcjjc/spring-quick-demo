package org.ckj.ssh.controller;

import lombok.RequiredArgsConstructor;
import org.ckj.ssh.exception.ParameterException;
import org.ckj.ssh.pojo.dto.SysUserDTO;
import org.ckj.ssh.response.CommonResponse;
import org.ckj.ssh.service.SysUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ckj
 * @CreateTime: 2024-11-08  10:47
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "sysuser")
@RequiredArgsConstructor
public class SysUserController {
    private final SysUserService sysUserService;


    /**
     * @description: 登录操作
     * @author: ckj
     * @date: 2024/11/8 上午11:34
     * @param: [username, password]
     * @return: org.ckj.ssh.response.CommonResponse
    **/
    @GetMapping("login")
    public CommonResponse login(String username, String password){
        boolean result = false;
        try {
            result = sysUserService.login(username, password);
        } catch (ParameterException e) {
            return CommonResponse.failure(e.getCode(),e.getMessage());
        }
        return result ? CommonResponse.success("登录成功") : CommonResponse.failure("登录失败");
    }

    /**
     * @description: 根据Id获取用户信息
     * @author: ckj
     * @date: 2024/11/8 下午1:45
     * @param: [id]
     * @return: org.ckj.ssh.response.CommonResponse<org.ckj.ssh.pojo.dto.SysUserDTO>
    **/
    @GetMapping("info")
    public CommonResponse<SysUserDTO> info(Integer id) {
        SysUserDTO sysUserDTO =null;
        try {
            sysUserDTO = sysUserService.info(id);
        } catch (ParameterException e) {
            return CommonResponse.failure(e.getCode(),e.getMessage());
        }
        return CommonResponse.success("成功",sysUserDTO);
    }
}
