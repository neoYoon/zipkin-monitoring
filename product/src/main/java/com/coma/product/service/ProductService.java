package com.coma.product.service;

import java.util.HashMap;

public interface ProductService {
    HashMap<String, Object> addProduct(String name);

    String getProduct(String product);
}
