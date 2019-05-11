package com.coma.product.service.impl;

import com.coma.product.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@Service
public class ProductServiceImpl implements ProductService {
    private HashMap<String, Object> data = new HashMap<>();

    @PostConstruct
    private void makeProduct() {
        data.put("1","ProductA");
        data.put("2","ProductB");
        data.put("3","ProductC");
    }

    @Override
    public String getProduct(String product) {
        return (String) data.get(product);
    }

    @Override
    public String getErrorProduct(String product) {
        throw new RuntimeException("get Product Error");
    }
}
