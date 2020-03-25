package com.springboot.providerticket.service;

import org.springframework.stereotype.Service;

@Service
public class TicketService {

    public String getTicket(){
        System.out.println("provider-8002");
        return "买的票";
    }
}
