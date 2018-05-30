package com.me.demo.javamodles.factory;


/**
 * 黑种人抽象类
 * @author ljh
 *
 */
public abstract class AbstractBlackHuman implements Human {

	public void color(){
    	System.out.println("黑色");
    }
	
	// 抽象方法
	public abstract void area();
	
}