package com.me.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieHttpSessionStrategy;
import org.springframework.session.web.http.DefaultCookieSerializer;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
//@EnableAsync
@EnableRedisHttpSession
/*Spring Boot提供一个方便的 @SpringBootApplication 
 * 选择该 @SpringBootApplication 注解等价于以默认属性使用 @Configuration ， @EnableAutoConfiguration 和 @ComponentScan */
public class Startup {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Startup.class);
        app.run(args);
    }
    
    /**
     * 修改DispatcherServlet默认配置
     *
     */
    @Bean
    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
        registration.getUrlMappings().clear();
        registration.addUrlMappings("*.do");
        registration.addUrlMappings("*.json");
        registration.addUrlMappings("**");
        return registration;
    }
    
    /*
	* 用来设置session时长
	* */
	@Bean
	public CookieHttpSessionStrategy cookieHttpSessionStrategy(){
		CookieHttpSessionStrategy strategy=new CookieHttpSessionStrategy();
		DefaultCookieSerializer cookieSerializer=new DefaultCookieSerializer();
		cookieSerializer.setCookieName("MYSESSIONID");//cookies名称
		cookieSerializer.setCookieMaxAge(1800);//过期时间(秒)
		strategy.setCookieSerializer(cookieSerializer);
		return strategy;
	}
    
}
