package org.ckj.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ckj
 * @CreateTime: 2024-11-08  15:03
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("security")
public class HelloController {

    @GetMapping("hello")
    public String hello() {
        return "hello";
    }
}
