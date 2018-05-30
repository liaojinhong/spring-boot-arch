package com.me.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

import com.me.demo.servlet.MyServlet;

/**
 * Servlet的统一注册类 这是代码注册，如果采用标签注册，可以去掉这个类，但是需要每个servlet类上面打上3个标签：分别是：
 * 
 * @Configuration @SevletComponentScan @WebServlet(urlpatterns="/xs/myServlet")
 *                如MyServlet类
 * 
 * @author ljh
 * 
 */
@Configuration
public class ServletConfig {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 修改DispatcherServlet默认配置
	 * 
	 * @param dispatcherServlet
	 * @return
	 */
	@Bean
	public ServletRegistrationBean modifyDispatcherServlet(
			DispatcherServlet dispatcherServlet) {
		ServletRegistrationBean registration = new ServletRegistrationBean(
				dispatcherServlet);
		logger.info(registration.getServletName());
		registration.getUrlMappings().clear();
		// registration.addUrlMappings("*.do");
		// registration.addUrlMappings("*.json");
		return registration;
	}

	/**
	 * 注册MyServlet
	 * 
	 * @return
	 */
	@Bean
	public ServletRegistrationBean myServletRegist() {
		ServletRegistrationBean registration = new ServletRegistrationBean(
				new MyServlet(), "/xs/myServlet");
		return registration;
	}

}
