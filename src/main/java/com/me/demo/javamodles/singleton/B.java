package com.me.demo.javamodles.singleton;


/**
 * Singleton 单例模式 饿汉模式
 * 
 * @author ljh
 * 
 */
public class B {

	private B() {
	};

	private static B b = new B();

	public static B getInstance() {
		System.out.println("Singleton饿汉模式 实例创建成功");
		return b;
	}
}
