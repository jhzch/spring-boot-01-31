package com.jh.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.jh.springboot.service.SendSms;
import com.jh.springboot.utils.RedisUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin  //跨域支持
public class SmsApiController {
    @Autowired
    private SendSms sendSms;

    @Autowired
    private RedisUtils redisUtils;

    @GetMapping("/send/{phone}")
    public String code(@PathVariable("phone")String phone){
        String code = redisUtils.get(phone).toString();
        if(StringUtils.isNotEmpty(code)){
            return phone+":"+"已存在，还没有过期";
        }

        //生成验证码并存储到redis中
        code = UUID.randomUUID().toString().substring(0,4);
        Map<String,Object> map = new HashMap<>();
        map.put("code", JSONObject.toJSONString(map));
        boolean flag = sendSms.send(phone,"SMS_19950616",map);

        if(flag){
            redisUtils.set(phone,code,300); //设置五分钟之后过期
            return phone+":"+code+" 发送成功！";
        }else{
            return "发送失败";
        }
    }
}
