package com.me.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.me.demo.redis.RedisClient;

@RestController 
@RequestMapping("/redis") 
public class RedisController {

	@Autowired
	RedisClient redisClient;
	
	@RequestMapping("/set/{key}-{value}")
	public String set(@PathVariable("key")String key, @PathVariable("value")String value) throws Exception{
		redisClient.set(key, value);
		//redisClient.set("a", "apple");
		return "success";
	}
	
	@RequestMapping("/get/{key}")
	public String get(@PathVariable("key")String key) throws Exception {
		return redisClient.get(key);
	}
}
