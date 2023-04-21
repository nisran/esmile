package com.esmile.common.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.PrivilegedExceptionAction;
import java.util.Enumeration;

/**
 * @Classname CurrentuserFilter
 * @Description TODO
 * @Version 1.0.0
 * @Date 15/4/2023 下午7:19
 * @Created by nisran
 */

@Data
@Component
@WebFilter("/*")
public class CurrentUserFilter implements Filter {

    private String userId;


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        // if health check request，wont go to filter chain

        this.userId = request.getHeader("userId");
        filterChain.doFilter(servletRequest, servletResponse);
    }

}
