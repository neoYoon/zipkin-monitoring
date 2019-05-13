package com.coma.product.service.impl;

import brave.Tracer;
import com.coma.product.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {
    private HashMap<String, Object> data = new HashMap<>();
    private int idx = 0;
    private Random random = new Random();

    @Autowired
    private Tracer tracer;

    @PostConstruct
    private void makeUser() {
        data.put("1","UserA");
        data.put("2","UserB");
        data.put("3","UserC");
    }

    @Override
    public String getUser(String user) throws InterruptedException {
//        int millis = this.random.nextInt(1000);

//        this.tracer.currentSpan().tag("random-sleep-millis", String.valueOf(millis));
        return (String) data.get(user);
    }
}
