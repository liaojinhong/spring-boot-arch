package com.me.demo.javamodles.singleton;


/**
 * Singleton 单例模式 懒汉模式
 * @author ljh
 *
 */
public class A {

	private A() {
	};

	private static A a = null;

	public static A getInstance() {

		if (null == a) {
			a = new A();
		}
		System.out.println("Singleton懒汉模式 实例创建成功");
		return a;
	}
}

