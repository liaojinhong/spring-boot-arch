package com.me.demo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.me.demo.filter.MyFilter;

/**
 * 过滤器统一配置
 * @author ljh
 *
 */
@Configuration
public class FilterConfig {

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		MyFilter actionFilter = new MyFilter();
		registrationBean.setFilter(actionFilter);
		List<String> urlPatterns = new ArrayList<String>();
		urlPatterns.add("/xs/*");
		registrationBean.setUrlPatterns(urlPatterns);
		return registrationBean;
	}
	
}
