package com.me.demo.util;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Session过滤器
 */
public class SessionFilter implements Filter {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
    Map ignoreServlet = Collections.synchronizedMap(new HashMap());

    public void destroy() {
        ignoreServlet.clear();
    }

    /**
     * actionType为login表示登录动作， <br>
     * 否则在session中检查是否有user对象，如果没有则表示session超时， <br>
     * 自动导航到/common/Login.jsp
     * 
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String actionType = httpServletRequest.getParameter("actionType");
        HttpSession session = httpServletRequest.getSession(false);
        String servletPath = httpServletRequest.getServletPath();
        if (servletPath != null && ignoreServlet.containsKey(servletPath)) {
            chain.doFilter(request, response);
            return;
        }
        if (session == null) {
            if (actionType != null) {
                if (actionType.equalsIgnoreCase("login")) {
                    chain.doFilter(request, response);
                    return;
                }
            }
            request.getRequestDispatcher("/common/Login.jsp").forward(request,
                    response);
            return;
        }
        if (session.getAttribute("user") == null) {
            if (actionType != null) {
                if (actionType.equalsIgnoreCase("login")) {
                    chain.doFilter(request, response);
                    return;
                }
            }
            request.getRequestDispatcher("/common/Login.jsp").forward(request,
                    response);
            return;
        }
        chain.doFilter(request, response);
    }

    /**
     * Place this filter into service.
     * 
     * @param filterConfig The filter configuration object
     * @throws ServletException
     */
    public void init(FilterConfig filterConfig) throws ServletException {
        String ignoreServletPath = filterConfig
                .getInitParameter("ignoreServlet");
        if (ignoreServletPath != null) {
            logger.info("IgnoreServlet=" + ignoreServletPath);
            ignoreServlet.putAll(StringUtils.toMap(ignoreServletPath, ","));
        }
    }
}