package com.springboot.demo06;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// 批量扫描所有的mapper
//@MapperScan(value = "com.springboot.demo06.mapper")
@SpringBootApplication
public class Demo06Application {
    public static void main(String[] args) {
        SpringApplication.run(Demo06Application.class, args);
    }

}
