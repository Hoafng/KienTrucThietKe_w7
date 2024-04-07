package com.example.demoproduct.controllers;

import com.example.demoproduct.entity.Product;
import com.example.demoproduct.entity.User;
import com.example.demoproduct.repo.ProductReponsitory;
import com.example.demoproduct.serivces.ProService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/Product")
public class ProductController {
    public ProService proService;

    @GetMapping("/products")
    public List<Product> getallProduct(){
        return proService.getlistPro();
    }
}
