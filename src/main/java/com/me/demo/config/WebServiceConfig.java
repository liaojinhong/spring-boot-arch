package com.me.demo.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;


/**
 * 服务端配置spring boot ws
 * 类继承：WsConfigurerAdapter
 * @author ljh
 *
 */
@EnableWs
@Configuration
//启动后访问 http://localhost:7001/ws/countries.wsdl 发现web service已经成功发布了。
public class WebServiceConfig extends WsConfigurerAdapter{
	
	
	/**
	 * 注册一个servlet,并设置上下文，指定访问路径
	 * @param applicationContext
	 * @return
	 */
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext){
		MessageDispatcherServlet servlet=new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet,"/ws/*");
	}
	
	
	/**
	 * 发布一个ws服务
	 * @param countriesSchema
	 * @return
	 */
	@Bean(name="countries")  //这里 name 默认就是发布的ws的访问路径
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema countriesSchema){
		DefaultWsdl11Definition wsdl11Definition=new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("CountriesPort");
		wsdl11Definition.setSchema(countriesSchema);
		return wsdl11Definition;
	}
	
	
	/**
	 * 读取并解析xsd文件
	 * @return
	 */
	@Bean
	public XsdSchema countriesSchema(){
		return new SimpleXsdSchema(new ClassPathResource("schema/countries.xsd"));
	}
	
	
}
