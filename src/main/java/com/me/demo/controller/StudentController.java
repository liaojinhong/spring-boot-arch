package com.me.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.me.demo.entity.Student;
import com.me.demo.repository.StudentRepository;

/**
 * Controller层，提供restful服务
 * 
 * @author ljh
 *
 */
@RestController // 注解为rest controller   
@RequestMapping("/user")   // 请求路径  类注解
public class StudentController {  
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	StudentRepository studentDao;
	
	@RequestMapping("/query/all") // 请求路径  方法注解   
    public Iterable<Student> query() { 
        return studentDao.findAll();    
    }    
	
    @RequestMapping("/query/{id}") // 请求路径  方法注解   
    public Student query(@PathVariable("id") Integer id) { // @PathVariable 路径参数，将路径中带的指定参数，传入到方法中的指定参数
    	logger.debug("this is a debug message");
    	logger.info("this is a info message");
    	logger.warn("this is a warn message");
    	logger.error("this is a error message");
        return studentDao.findOne(id);    
    }    
    
    @RequestMapping("/save/{name}")    
    public String save(@PathVariable("name") String name) {
		studentDao.save(new Student(name,10));
		return name+"保存成功!";  
    }  
    
    @RequestMapping("/delete/{id}")    
    public String delete(@PathVariable("id") Integer id) {
        studentDao.delete(id);    
        return id+"删除成功!";  
    }   
    
    
}