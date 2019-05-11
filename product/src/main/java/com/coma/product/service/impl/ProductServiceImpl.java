package com.coma.product.service.impl;

import com.coma.product.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ProductServiceImpl implements ProductService {
    private HashMap<String, Object> data = new HashMap<>();
    private int idx = 0;

    @Override
    public HashMap<String, Object> addProduct(String name) {
        idx++;
        data.put(Integer.toString(idx), name);
        return data;
    }

    @Override
    public String getProduct(String product) {
        return (String) data.get(product);
    }
}
