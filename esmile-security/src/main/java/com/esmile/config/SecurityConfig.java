package com.esmile.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 这个配置的重要性
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailService userDetailService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService);
    }

    @Bean
    public BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/index.html") //自定义登录页面
                .loginProcessingUrl("/user/login")
                .defaultSuccessUrl("/loginSuccess")
                .and().authorizeRequests()
                    .antMatchers("/healthCheck", "/index.html").permitAll()
                    .antMatchers("/user/admin").hasAuthority("admin")
                    .anyRequest().authenticated()
                .and()
                .csrf().disable();    //关闭csrf保护
    }
}
