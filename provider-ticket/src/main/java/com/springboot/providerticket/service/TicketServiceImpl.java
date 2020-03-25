package com.springboot.providerticket.service;



import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.stereotype.Component;
@EnableDubbo
@Component
@Service // 将服务发布出去  org.apache.dubbo.config.annotation.Service;
public class TicketServiceImpl implements TicketService{
    @Override
    public String getTicket() {
        return "电影票";
    }
}
