package com.me.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.me.demo.interceptor.MyInterceptor;

/**
 * 拦截器统一配置
 * 
 * @author ljh
 * 
 */

@EnableWebMvc
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

	@Bean
	public MyInterceptor getMyInterceptor() {
		return new MyInterceptor();
	}
	

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 多个拦截器组成一个拦截器链
		// addPathPatterns 用于添加拦截规则
		// excludePathPatterns 用户排除拦截
		registry.addInterceptor(getMyInterceptor()).addPathPatterns("/user/query/**");
		//registry.addInterceptor(getMyInterceptor1()).addPathPatterns("/user/query/**");
		//registry.addInterceptor(getMyInterceptor2()).addPathPatterns("/user/query/**");
		super.addInterceptors(registry);
	}

}
