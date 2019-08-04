package com.supertrampai.springbootsimplefilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author lxh800109@gmail.com
 * @Description
 * @create 2019/08/04 12:40
 */
@Component
@Order(1)
public class TransactionFilter implements Filter {

    static final Logger logger = LoggerFactory.getLogger(TransactionFilter.class);

    @Override
    public void doFilter
            (ServletRequest request,
             ServletResponse response,
             FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        logger.info(
                "Starting a transaction for req : {}",
                req.getRequestURI());

        chain.doFilter(request, response);
        logger.info(
                "Committing a transaction for req : {}",
                req.getRequestURI());
    }

    // other methods
}