package com.jh.springboot.service;

import com.jh.springboot.utils.RedisUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class UserService {

//    @Autowired
//    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RedisUtils redisUtils;

    /**
     * 发送短信验证码
     * @param mobile
     */
    public void sendMessage(String mobile){
        Random random = new Random();
        int max = 999999;//最大数
        int min = 100000;//最小数
        int code = random.nextInt(max);
        if(code<min){
            code = code+min;
        }
        System.out.println("收到的验证码是："+code);
        //将验证码放入redis
        redisUtils.set("smscode_"+code,code,5*60*60); //五分钟过期

        //将验证码和手机号发送到rabbitmq中
        Map<String,String> map = new HashMap<>();
        map.put("mobile",mobile);
        map.put("code",code+"");
//        rabbitTemplate.convertAndSend("sms",map);

    }

}
