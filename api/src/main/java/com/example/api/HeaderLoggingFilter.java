package com.example.api;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collections;
import java.util.UUID;

@Component
public class HeaderLoggingFilter extends GenericFilterBean {

//    private static final Logger logger = (Logger) LoggerFactory.getLogger(HeaderLoggingFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        logger.info("===After===================================");
        for(String name : Collections.list(((HttpServletRequest) request).getHeaderNames())) {
            logger.info(name + " : " + ((HttpServletRequest) request).getHeader(name));
        }
        logger.info("===========================================");

        chain.doFilter(request, response);

    }

}
