package com.me.demo.config;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

// 若不配置线程池，就调用默认的线程池执行，自定义线程池，可以自定义线程池参数，控制线程执行

//声明这是一个配置类
@Configuration
//开启异步支持
@EnableAsync

//配置类实现AsyncConfigurer接口并重写AsyncConfigurer方法，并返回一个ThreadPoolTaskExecutor
//这样我们就得到了一个基于线程池的TaskExecutor
public class TaskExecutorConfig implements AsyncConfigurer{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//配置类实现AsyncConfigurer接口并重写AsyncConfigurer方法，并返回一个ThreadPoolTaskExecutor
    //这样我们就得到了一个基于线程池的TaskExecutor
    @Override
    public Executor getAsyncExecutor() {
        // TODO Auto-generated method stub
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        //如果池中的实际线程数小于corePoolSize,无论是否其中有空闲的线程，都会给新的任务产生新的线程
        taskExecutor.setCorePoolSize(5);
        //连接池中保留的最大连接数。Default: 15 maxPoolSize  
        taskExecutor.setMaxPoolSize(10);
        //queueCapacity 线程池所使用的缓冲队列
        taskExecutor.setQueueCapacity(25);
        taskExecutor.initialize();
        taskExecutor.setThreadNamePrefix("PoolTask-");//  线程名称前缀
        return taskExecutor;
    }
 
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        // TODO Auto-generated method stub
        return new MyAsyncExceptionHandler();
    }
    
    /**
     * 自定义异常处理类   内部类
     *
     */
    class MyAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

        //手动处理捕获的异常
		@Override
		public void handleUncaughtException(Throwable throwable,
				Method method, Object... obj) {
			 System.out.println("-------------》》》捕获线程异常信息");
	            logger.info("Exception message - " + throwable.getMessage());
	            logger.info("Method name - " + method.getName());
	            for (Object param : obj) {
	            	logger.info("Parameter value - " + param);
	            }
			
		}

    }
}
