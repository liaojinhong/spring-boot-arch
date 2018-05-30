package com.me.demo.javamodles.builder;


/**
 * 建造者模式测试
 * 
 * @author ljh
 *
 */
public class TestBuilder {

	public static void main(String[] args) {
		PersonDirect pd = new PersonDirect();
		PersonBuilder pb = new ManBuilder();
		Person person = pd.createPerson(pb);
		System.out.println(person.getHead());
		System.out.println(person.getBody());
		System.out.println(person.getFoot());

	}

}
