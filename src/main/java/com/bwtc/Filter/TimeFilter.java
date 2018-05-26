package com.bwtc.Filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.File;
import java.io.IOException;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 17:22 2018/5/26
 **/
@Component
public class TimeFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig)throws ServletException {
        System.out.println("=======初始化过滤器=========");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        long start = System.currentTimeMillis();
        filterChain.doFilter(request, response);
        System.out.println("filter 耗时：" + (System.currentTimeMillis() - start));
    }

    @Override
    public void destroy() {
        System.out.println("=======销毁过滤器=========");
    }
}
