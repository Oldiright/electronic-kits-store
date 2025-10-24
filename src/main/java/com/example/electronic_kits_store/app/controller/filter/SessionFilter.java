package com.example.electronic_kits_store.app.controller.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import java.io.IOException;
@Component
public class SessionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Cookie id = WebUtils.getCookie(request, "sessionId");
        if(id == null) {
            Cookie setId = new Cookie("sessionId", "#777777777");
            setId.setPath("/");
            response.addCookie(setId);
        }
        filterChain.doFilter(request, response);
    }
}
