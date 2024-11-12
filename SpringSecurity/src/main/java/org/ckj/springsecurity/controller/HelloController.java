package org.ckj.springsecurity.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
@RequiredArgsConstructor
public class HelloController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);
    @GetMapping("hello")
    public String hello() {
        log.info("hello");
        return "hello";
    }

    @GetMapping("info")
    public String info() {
        log.info("info");
        return "info";
    }
}
