package com.me.demo.controller;

import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.me.demo.async.AsyncTask;
//import com.me.demo.async.MainExecutor;

@RestController
public class AsyncTaskController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AsyncTask asyncTask;
	
//	@Autowired
//	private MainExecutor executor;

	@RequestMapping("/task")
	public void AsyncTaskTest1() throws InterruptedException,
			ExecutionException {
		asyncTask.doTask1();
		asyncTask.doTask2();
		logger.info("-----All tasks finished.----");
	}
	
//	@RequestMapping("/task2")
//	public void AsyncTaskTest2() throws InterruptedException,
//			ExecutionException {
//		logger.info("-----测试任务调度开始----");
//		executor.printMessages();
//		logger.info("-----测试任务调度结束----");
//	}

}
