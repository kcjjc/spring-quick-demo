package org.ckj.springsecurity.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author: ckj
 * @CreateTime: 2024-11-08  15:08
 * @Description: TODO
 * @Version: 1.0
 */
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        String[] urls = {
//                "/security/hello",
//        };
//
////        http.antMatcher("/security/hello")
////                .anonymous();
//
//        http.authorizeRequests()
//                .antMatchers(urls).permitAll();
//
//    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/security/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/security/hello")
                .permitAll();
    }
}
