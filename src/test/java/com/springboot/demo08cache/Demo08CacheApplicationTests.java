package com.springboot.demo08cache;

import com.springboot.demo08cache.bean.Employee;
import com.springboot.demo08cache.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo08CacheApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;


    @Test
    void contextLoads() {
        Employee emp = employeeMapper.getEmpById(1);
        System.out.println(emp);
    }

}
