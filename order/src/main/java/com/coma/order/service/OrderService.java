package com.coma.order.service;

import java.util.HashMap;

public interface OrderService {
    HashMap<String, Object> createOrder(String user, String product);

    HashMap<String, Object> createErrorOrder(String user, String product);
}
