package com.jh.springboot;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableRabbit   //开启基于注解的rabbitmq模式
@SpringBootApplication
public class SpringBoot0131Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot0131Application.class, args);
    }

}
