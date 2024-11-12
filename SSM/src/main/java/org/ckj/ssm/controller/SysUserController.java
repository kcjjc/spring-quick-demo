package org.ckj.ssm.controller;

import lombok.RequiredArgsConstructor;
import org.ckj.ssm.pojo.dto.SysUserDTO;
import org.ckj.ssm.response.CommonResponse;
import org.ckj.ssm.service.SysUserService;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: ckj
 * @CreateTime: 2024-11-08  14:28
 * @Description: SysUser 的控制层
 * @Version: 1.0
 */
@RestController
@RequestMapping("sysuser")
@RequiredArgsConstructor
public class SysUserController {
    private final SysUserService userService;

    /**
     * @description: 登录
     * @author: ckj
     * @date: 2024/11/12 上午10:23
     * @param: [username 账户,
     *          password 密码]
     * @return: org.ckj.ssm.response.CommonResponse<java.lang.String>
    **/
    @GetMapping(value = "login")
    public CommonResponse<String> login(String username, String password) {
        boolean login = userService.login(username, password);
        if (login) {
            return CommonResponse.success("登录成功");
        } else {
            return CommonResponse.failure("登录失败");
        }
    }

    /**
     * @description:
     * @author: ckj
     * @date: 2024/11/12 上午10:23
     * @param: [sysUserDTO]
     * @return: org.ckj.ssm.response.CommonResponse<org.ckj.ssm.pojo.dto.SysUserDTO>
    **/
    @GetMapping("get")
    public CommonResponse<SysUserDTO> get(@RequestBody SysUserDTO sysUserDTO) {
        return CommonResponse.success(userService.getAll(sysUserDTO));
    }


}
