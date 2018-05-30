//package com.me.demo.async;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.task.TaskExecutor;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MainExecutor {
//	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//	@Autowired
//	private TaskExecutor taskExecutor;
//
//	public MainExecutor(TaskExecutor taskExecutor) {
//		this.taskExecutor = taskExecutor;
//	}
//
//	public void printMessages() {
//		for (int i = 0; i < 25; i++) {
//			taskExecutor.execute(new MessagePrinterTask("Message" + i));
//		}
//	}
//
//	private class MessagePrinterTask implements Runnable {
//		private String message;
//
//		public MessagePrinterTask(String message) {
//			this.message = message;
//		}
//
//		public void run() {
//			System.out.println(message);
//		}
//	}
//
//}