package com.coma.order.controller;

import com.coma.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired private OrderService orderService;

    @GetMapping("/create/{user}/{product}")
    public HashMap<String, Object> createOrder(@PathVariable("user") String user, @PathVariable("product") String product) {

        return orderService.createOrder(user, product);
    }

    @GetMapping("/create/error/{user}/{product}")
    public HashMap<String, Object> createOrderError(@PathVariable("user") String user, @PathVariable("product") String product) {

        return orderService.createErrorOrder(user, product);
    }
}
