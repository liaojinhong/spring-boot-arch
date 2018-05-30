package com.me.demo.javamodles.singleton;

/**
 * 单例模式测试
 * 
 * @author ljh
 *
 */
public class TestSingleton {

	public static void main(String[] args) {
		A a1 = A.getInstance();
		A a2 = A.getInstance();
		if(a1 == a2){
			System.out.println("a1=a2");
		}else{
			System.out.println("a1<>a2");
		}
		
		B b1 = B.getInstance();
		B b2 = B.getInstance();		
		if(b1 == b2){
			System.out.println("b1=b2");
		}else{
			System.out.println("b1<>b2");
		}
	}

}