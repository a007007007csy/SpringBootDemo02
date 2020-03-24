package com.springboot.demo11task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling // 开启定时任务注解
@EnableAsync // 开启异步注解
@SpringBootApplication
public class Demo11TaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo11TaskApplication.class, args);
    }

}
