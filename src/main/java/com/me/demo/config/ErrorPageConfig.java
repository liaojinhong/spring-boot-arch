package com.me.demo.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * 错误页面配置，实现EmbeddedServletContainerCustomizer接口的customize方法
 * 
 * @author ljh
 *
 */
@Configuration
public class ErrorPageConfig {
    
    @Bean
    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer(){
        return new MyCustomizer();
    }
    
    private static class MyCustomizer implements EmbeddedServletContainerCustomizer {

        @Override
        public void customize(ConfigurableEmbeddedServletContainer container) {
            container.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN, "/403"));
        }

    }

}
