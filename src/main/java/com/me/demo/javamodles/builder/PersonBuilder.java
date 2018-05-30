package com.me.demo.javamodles.builder;


/**
 * 建造者接口
 * @author ljh
 *
 */
public interface PersonBuilder {

	public void buildHead();
	
	public void buildBody();
	
	public void buildFoot();
	
	public Person buildPerson();
	
}

