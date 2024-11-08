package org.ckj.springsecurity.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author: ckj
 * @CreateTime: 2024-11-08  15:08
 * @Description: TODO
 * @Version: 1.0
 */
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        String[] urls = {
                "security/hello",
        };


        // 不要保留调用父级同名方法的代码，不要保留！不要保留！不要保留！
        http.authorizeRequests()
                .mvcMatchers(urls)
                .permitAll();
    }
}
