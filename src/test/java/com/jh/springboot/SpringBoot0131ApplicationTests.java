package com.jh.springboot;

//import com.jh.springboot.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringBoot0131ApplicationTests {
//    Logger logger = LoggerFactory.getLogger(getClass());

//    @Autowired
//    private RedisTemplate<String,Object> redisTemplate;
//
//    @Autowired
//    private RedisUtils redisUtils;
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
////    @Test
////    void contextLoads() {
////        logger.trace("这是trace信息");
////        logger.debug("这是debug信息");
////        logger.info("这是info信息");
////        logger.warn("这是warn信息");
////        logger.error("这是error信息");
////    }
//    @Test
//    public void redisTest(){
//        redisTemplate.opsForValue().set("name","jh");
//        String name = (String) redisTemplate.opsForValue().get("name");
//
//        System.err.println("-----------name的值："+name);
//    }
//
//    @Test
//    public void sendMessage(){
//       Map<String,Object> map = new HashMap<>();
//       map.put("msg","发出的第一条消息");
//       map.put("data", Arrays.asList("hello",123,true));
//       rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",map);
//   }
//
//   @Test
//    public void receiveMessage(){
//        Object o = rabbitTemplate.receiveAndConvert("atguigu.news");
//       System.out.println(o.getClass());
//       System.out.println(o);
//   }


}
