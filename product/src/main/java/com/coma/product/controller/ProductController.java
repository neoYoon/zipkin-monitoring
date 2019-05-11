package com.coma.product.controller;

import com.coma.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired private ProductService productService;

    @RequestMapping("/home")
    public String home(){
        return "product home";
    }

    @PostMapping("/add")
    public HashMap<String, Object> addProduct(@RequestParam String name) {
        return productService.addProduct(name);
    }

    @GetMapping("/get/{product}")
    public String getProduct(@PathVariable("product") String product ) {
        return productService.getProduct(product);
    }
}
