package com.springboot.demo09amqp.service;

import com.springboot.demo09amqp.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    // 要监听的消息队列
    @RabbitListener(queues = "springbootdemo.news")
    public void receive(Book book){
        System.out.println("收到的信息"+book);
    }

    @RabbitListener(queues = "springbootdemo")
    public void receive02(Message message){
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
