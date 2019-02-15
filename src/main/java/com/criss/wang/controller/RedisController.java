package com.criss.wang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.criss.wang.entity.Member;

@RestController
public class RedisController {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@RequestMapping(value = "/get/value", method = RequestMethod.GET)
	public String  testGet() {
		System.out.println(this.redisTemplate.opsForValue().get("study"));
		return "success";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String testSet() {
		Member vo = new Member();
		vo.setMid("wangqiubao");
		vo.setAge(19);
		this.redisTemplate.opsForValue().set("study", vo);
		return "success";
	}
}
