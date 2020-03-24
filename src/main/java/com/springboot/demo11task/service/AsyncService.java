package com.springboot.demo11task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 异步任务
 */
@Service
public class AsyncService {

    // 告诉spring这是一个异步方法
    @Async
    public void hello() {
        try {
            Thread.sleep(3000);
            System.out.println("数据处理中");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
