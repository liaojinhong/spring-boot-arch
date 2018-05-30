package com.me.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 定时任务的统一配置
 * @author ljh
 *
 */
@Configuration
//@EnableScheduling   // @EnableScheduling 开启定时任务配置
public class SchedulingConfig {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	// CronTrigger配置完整格式为： [秒] [分] [小时] [日] [月] [周] [年](年非必填项)
	// 参照笔记  java常用技能   quartz CronExpression表达式   
	
	//@Scheduled(cron = "*/5 * * * * ?") // 每5秒钟执行一次  
	public void getToken1(){
		logger.info("getToken1--定时任务启动");
	}
	
	//@Scheduled(fixedRate = 5000) // 每5秒钟执行一次
	public void getToken2(){
		logger.info("getToken2--定时任务启动");
	}
	
	
	/*说明

	在spring-boot中需要在类上添加@EnableScheduling注解来开启对计划任务的支持。

	在开启对计划任务的支持后，需要@Scheduled注解的配合。@Scheduled是方法上注解，添加该注解的方法即为单个计划任务。@Scheduled注解定义了计划任务的执行计划,有两种方式可以定义： 
	1.@Scheduled(fixedRate = 5000) //通过@Scheduled声明该方法是计划任务，使用fixedRate属性每隔固定时间5秒执行一次 
	2.@Scheduled(cron = “0 0/10 * * * ?”) //使用cron属性可按照指定时间执行，本例指的是每10分钟执行一次；
	
	
	 */
	}
