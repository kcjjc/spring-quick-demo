package org.ckj.ssm.controller;

import lombok.RequiredArgsConstructor;
import org.ckj.ssm.response.CommonResponse;
import org.ckj.ssm.service.SysUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ckj
 * @CreateTime: 2024-11-08  14:28
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("sysuser")
@RequiredArgsConstructor
public class SysUserController {
    private final SysUserService userService;

    @GetMapping(value = "login")
    public CommonResponse login(String username, String password) {
        boolean login = userService.login(username, password);
        if (login) {
            return CommonResponse.success("登录成功");
        } else {
            return CommonResponse.failure("登录失败");
        }
    }
}
