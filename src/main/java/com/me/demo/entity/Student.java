package com.me.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 实体对象 ，用Entity关键词注解
 * 
 * @author ljh
 *
 */
@Entity
@Table(name="Student")  // 类与表名映射，同名可以省略
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // 主键生成策略，使用自增。 注意：Student表，id字段要手动设置为自动递增，并且要设置id为主键
	private Integer id;
	
	private String name;
	
	private int age;
	//默认构造函数   必须有
    public Student(){
    	
    }
    
	public Student(String name, Integer age){
		this.name = name;
		this.age = age;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
