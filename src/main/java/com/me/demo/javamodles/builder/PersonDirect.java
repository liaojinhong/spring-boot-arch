package com.me.demo.javamodles.builder;


/**
 * 指导者角色
 * @author ljh
 *
 */
public class PersonDirect {

	public Person createPerson(PersonBuilder pb){
		pb.buildHead();
		pb.buildBody();
		pb.buildFoot();		
		return pb.buildPerson();
	}

	
}

