package com.me.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.me.demo.entity.Student;

/**
 * 数据访问接口，继承CrudRepository
 * 
 * @author ljh
 *
 */
public interface StudentRepository extends CrudRepository<Student,Integer> {

	
}
