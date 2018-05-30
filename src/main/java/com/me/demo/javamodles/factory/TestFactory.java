package com.me.demo.javamodles.factory;

/**
 * 工厂模式测试
 * 
 * @author ljh
 *
 */
public class TestFactory {

	public static void main(String[] args) {
		AbstractBlackHuman americanBlackHuman = new AmericanBlackHuman();
		americanBlackHuman.color();
		americanBlackHuman.area();
	}

}

