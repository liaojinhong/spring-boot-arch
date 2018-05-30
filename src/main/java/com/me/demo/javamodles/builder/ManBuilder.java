package com.me.demo.javamodles.builder;


/**
 * 建造者具体实现
 * @author ljh
 *
 */
public class ManBuilder implements PersonBuilder {

	Person person;
	public ManBuilder(){
		person = new Person();
	}
	public void buildHead() {
		person.setHead("建造头部");
	}

	public void buildBody() {
		person.setBody("建造身体");
	}

	public void buildFoot() {
		person.setFoot("建造脚");
	}

	public Person buildPerson() {
		return person;
	}

}
