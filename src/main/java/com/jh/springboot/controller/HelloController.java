package com.jh.springboot.controller;

import com.jh.springboot.entity.Animanl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Api("hello控制类")
@RestController
public class HelloController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
//
//    @Autowired
//    private RabbitTemplate rabbitTemplate;


    @ApiOperation("hello方法")
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(Animanl animanl){
//        StringBuilder sb = new StringBuilder("gg").append(name);
        return "你好世界！"+animanl;
    }
}
