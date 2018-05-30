package com.me.demo.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 单元测试
 * @BeforeClass @AfterClass 这两个方法只执行一次
 * 测试方法@Test，每调用一个测试方法，就执行一次@Before 和 @After方法，每个测试方法相对独立
 * 
 * @author ljh
 *
 */
public class MyClassTest {

	private String var1;

	@BeforeClass
	public static void testBeforeClass() {
		System.out.println("[@BeforeClass](testBeforeClass)<must by static>"
				+ "hello before class");
	}

	@Before
	public void testBefore() throws Exception {
		System.out.println("[@Before](--runing--)" + var1);
		var1 = "Test Before";
	}

	@Test
	public void testMethod1() {
		System.out.println("[@Test](testMethod1----)" + var1);
	}
	
	@Test
	public void testMethod2() {
		System.out.println("[@Test](testMethod2----)" + var1);
	}

	@After
	public void testAfter() {
		var1 = "Test After";
		System.out.println("[@After](--runing--)" + var1);
	}

	@AfterClass
	public static void testAfterClass() {
		System.out.println("[@AfterClass](testAfterClass)<must by static>"
				+ "byebye after class");
	}

}