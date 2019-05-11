package com.coma.order.service.impl;

import com.coma.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class OrderServiceImpl implements OrderService {
    private int idx = 0;

    @Autowired RestTemplate restTemplate;
    @Override
    public HashMap<String, Object> createOrder(String user, String product) {
        String productResult = restTemplate.getForObject("http://localhost:8081/product/get/" + product, String.class);
        String userResult = restTemplate.getForObject("http://localhost:8082/user/get/" + user, String.class);

        idx++;
        HashMap<String, Object> orderResult = new HashMap<>();

        orderResult.put(Integer.toString(idx), "product : " + productResult + " user : " + userResult);

        return orderResult;
    }

    @Override
    public HashMap<String, Object> createErrorOrder(String user, String product) {
        String productResult = restTemplate.getForObject("http://localhost:8081/product/getError/" + product, String.class);
        String userResult = restTemplate.getForObject("http://localhost:8082/user/get/" + user, String.class);

        idx++;
        HashMap<String, Object> orderResult = new HashMap<>();

        orderResult.put(Integer.toString(idx), "product : " + productResult + " user : " + userResult);

        return orderResult;
    }


}
