package com.coma.product.controller;

import brave.Span;
import brave.Tracer;
import com.coma.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired ProductService productService;
    @Autowired
    private Tracer tracer;

    @RequestMapping("/home")
    public String home(){
        return "product home";
    }

    @GetMapping("/get/{product}")
    public String getProduct(@PathVariable("product") String product) {
        return productService.getProduct(product);
    }

    @GetMapping("/getError/{product}")
    public String getErrorProduct(@PathVariable("product") String product, @RequestHeader(value = "X-B3-TraceId") String traceId) {
        Span currentSpan = this.tracer.currentSpan();
        System.out.println("traceId" + traceId);
        System.out.println("currentSpan" + currentSpan);
        return productService.getErrorProduct(product);
    }
}
