package com.springboot.consumeruser;

import com.springboot.consumeruser.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConsumerUserApplicationTests {

    @Autowired
    UserService userService;
    @Test
    void contextLoads() {
        userService.hello();
    }

}
