package org.ckj.springswagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ckj
 * @CreateTime: 2024-11-12  16:27
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "spsw")
@Api(value = "登录接口",tags = {"用户接口"})
public class LoginController {

    @ApiOperation(value = "hello")
    @GetMapping(value = "hello")
    public String hello() {
        return "hello";
    }

    @ApiOperation(value = "login")
    @GetMapping(value = "login")
    public String login() {
        return "login";
    }

}
