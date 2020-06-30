package com.jh.springboot.service;

import com.jh.springboot.entity.Book;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookService {
//    @RabbitListener(queues = "atguigu.news")
//    public void recieve(Book book){
//        System.out.println();
//    }
}
